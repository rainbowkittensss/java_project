package edu.hw2;

import edu.hw1.Main;
import java.util.Random;
import static edu.hw2.Main.LOGGER;

public class Task3 {
    static boolean strContainsDigits(String str) {
        return str.contains("1") || str.contains("2") || str.contains("3") ||
            str.contains("4") || str.contains("5") || str.contains("6") ||
            str.contains("7") || str.contains("8") || str.contains("9");
    }

   static Random rand = new Random();
    final static int LITTLE_CHANCE = 1000;
    final static int BIG_CHANCE = 100000;
    static boolean isActionSuccessful(int chance){
        if(chance==LITTLE_CHANCE)
        return rand.nextInt()<LITTLE_CHANCE;
        else return rand.nextInt()<BIG_CHANCE;
    }
    public interface Connection extends AutoCloseable {

        void execute(String command) throws ConnectionException;

    }

    public static class StableConnection implements Connection {

        @Override
        public void execute(String command) {
            LOGGER.info(command + "executed successfully!");
        }

        @Override
        public void close() throws Exception {
            if (isActionSuccessful(BIG_CHANCE)) {
                throw new ConnectionException(new Exception());
            }
            LOGGER.info("The StableConnection closed.");
        }
    }

    public static class FaultyConnection implements Connection {

        @Override
        public void execute(String command) throws ConnectionException {
            if (isActionSuccessful(LITTLE_CHANCE)) {
                throw new ConnectionException(new Exception());
            } else {
                LOGGER.info(command.concat(" executed successfully!"));

            }
        }

        @Override
        public void close() throws Exception {
            if (isActionSuccessful(LITTLE_CHANCE)) {
                throw new ConnectionException(new Exception());
            }
            LOGGER.info("The FaultyConnection closed.");
        }
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public static class DefaultConnectionManager implements ConnectionManager {

        @Override
        public Connection getConnection() {
            if (isActionSuccessful(BIG_CHANCE)) {
                return new StableConnection();
            } else {
                return new FaultyConnection();
            }
        }
    }

    public static class FaultyConnectionManager implements ConnectionManager {

        @Override
        public Connection getConnection() {
            return new FaultyConnection();
        }
    }

    public static class ConnectionException extends Exception {
        Exception cause;

        ConnectionException(Exception cs) {
            cause = cs;
        }
    }

    public final static class PopularCommandExecutor {
        private final ConnectionManager manager;
        private final int maxAttempts = 100;
        static final int MAX_LENGTH_OF_CMD = 100;

        static boolean validateCommand(String command) {
            String[] verbs = command.split(" ");
            return !(command.isEmpty() || strContainsDigits(verbs[0]) ||
                verbs[0].length() > MAX_LENGTH_OF_CMD);
        }

        PopularCommandExecutor() {
            if(isActionSuccessful(BIG_CHANCE))
            manager = new DefaultConnectionManager();
            else manager = new FaultyConnectionManager();
        }

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        void tryExecute(String command) {
            Connection connection = manager.getConnection();
            int attemptCount = 0;
            boolean failed = true;
            if (validateCommand(command)) {
                while (attemptCount < maxAttempts && failed) {
                    try {
                        failed = false;
                        connection.execute(command);
                    } catch (ConnectionException e) {
                        attemptCount += 1;
                        failed = true;
                    }

                }
            }
        }
    }
}
