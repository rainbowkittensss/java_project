package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.logging.Logger;

public class Task6 {
    private Task6() {
    }

    static HashMap<Integer, String> listOfPortsInfo = new HashMap<>();
    static final Logger LOGGER = Logger.getLogger("logger");
    static final int NUMBER_OF_PORTS = 49151;

    @SuppressWarnings("MagicNumber")
    public static void fullTheMap() {
        listOfPortsInfo.put(80, "HTTP (HyperText Transfer Protocol)");
        listOfPortsInfo.put(21, "FTP (File Transfer Protocol)");
        listOfPortsInfo.put(25, "SMTP (Simple Mail Transfer Protocol)");
        listOfPortsInfo.put(22, "SSH (Secure Shell)");
        listOfPortsInfo.put(443, "HTTPS (HyperText Transfer Protocol Secure)");
        listOfPortsInfo.put(3306, "MySQL Database");
        listOfPortsInfo.put(5432, "PostgreSQL Database");
        listOfPortsInfo.put(3389, "Remote Desktop Protocol (RDP)");
        listOfPortsInfo.put(27017, "MongoDB Database");
        listOfPortsInfo.put(1521, "Oracle Database");
        listOfPortsInfo.put(8080, "HTTP proxy server.");
        listOfPortsInfo.put(3128, "HTTPS proxy server");
        listOfPortsInfo.put(5900, "Virtual Network Computing for remote access.");
        listOfPortsInfo.put(123, "Network Time Protocol for time synchronization");
        listOfPortsInfo.put(2049, "Network File System for file sharing.");
        listOfPortsInfo.put(11211, "Memcached distributed memory caching system");
        listOfPortsInfo.put(5353, "Zero Configuration Networking for automatic network configuration.");
        listOfPortsInfo.put(1723, "Point-to-Point Tunneling Protocol for VPN connections.");
        listOfPortsInfo.put(
            16384,
            "Real-time Transport Protocol for audio and video transmission & "
                + "\nReal-time Control Protocol for audio and video transmission."
        );
    }

    public static boolean[] isPortFree = new boolean[NUMBER_OF_PORTS + 1];

    public static void searchSockets() {
        StringBuilder theInfo = new StringBuilder("List of active sockets and theirs appointments\n");
        if (listOfPortsInfo.isEmpty()) {
            fullTheMap();
        }
        for (int i = 1; i < NUMBER_OF_PORTS + 1; ++i) {
            try (ServerSocket socket = new ServerSocket(i)) {
                DatagramSocket dataSocket = null;
                if (socket.isBound()) {
                    socket.close();
                    dataSocket = new DatagramSocket(i);
                }
                if (dataSocket != null) {
                    dataSocket.close();
                }
                isPortFree[i] = true;
            } catch (IOException exc) {
                isPortFree[i] = false;
            }
            if (isPortFree[i] && listOfPortsInfo.containsKey(i)) {
                theInfo.append("Socket number: ")
                    .append(i)
                    .append(" is used for: ")
                    .append(listOfPortsInfo.get(i))
                    .append("\n");
            }
        }
        LOGGER.info(theInfo.toString());
    }
}
