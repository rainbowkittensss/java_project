package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Task3 {
    public interface AbstractFilter extends DirectoryStream.Filter<Path> {
        AbstractFilter and(AbstractFilter filter);

        Predicate<Path> getFunction();

    }

    public abstract static class AbstractFilterDefault implements AbstractFilter {
        protected Predicate<Path> function;

        @Override
        public AbstractFilter and(AbstractFilter filter) {
            andForFunction(filter.getFunction());
            return this;
        }

        private void andForFunction(Predicate<Path> predicate) {
            function = path -> predicate.test(path) && function.test(path);
        }

        @Override
        public Predicate<Path> getFunction() {
            return function;
        }

        @Override
        public boolean accept(Path entry) {
            return function.test(entry);
        }

    }

    public static class FilterAtrributes extends AbstractFilterDefault {
        public enum TypeOfAttribute {
            READABLE,
            WRITABLE,
            EXECUTABLE,
            HIDDEN

        }

        public FilterAtrributes(TypeOfAttribute type) {
            function = switch (type) {
                case HIDDEN -> path -> {
                    boolean ans = false;
                    try {
                        ans = Files.isHidden(path);
                    } catch (IOException e) {
                        return false;
                    }
                    return ans;
                };
                case READABLE -> Files::isReadable;
                case WRITABLE -> Files::isWritable;
                case EXECUTABLE -> Files::isExecutable;
            };
        }
    }

    public static class FilterSize extends AbstractFilterDefault {
        public enum TypeOfCompare {
            MORE_THAN,
            LESS_THAN
        }

        public FilterSize(TypeOfCompare type, long size) {
            function = switch (type) {
                case MORE_THAN -> path -> {
                    try {
                        return Files.size(path) > size;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                };
                case LESS_THAN -> path -> {
                    try {
                        return Files.size(path) < size;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                };
            };
        }
    }

    public static class FilterFileType extends AbstractFilterDefault {
        public FilterFileType(String type) {
            function = path -> path.endsWith(type);
        }
    }

    public static class FilterFileName extends AbstractFilterDefault {
        public FilterFileName(String regEx) {
            function = path -> {
                Pattern pattern = Pattern.compile(regEx);
                return pattern.matcher(String.valueOf(path.getFileName())).matches();
            };
        }
    }

    @SuppressWarnings("MagicNumber")
    public static class FilterMagicIdentifiers extends AbstractFilterDefault {
        public FilterMagicIdentifiers(Set<Byte> identifiers) {
            function = path -> {
                try {
                    Set<Byte> identifiersCopy = new java.util.HashSet<>(Set.copyOf(identifiers));
                    byte[] file = Files.readAllBytes(path);
                    for (int i = 0; i < 8; ++i) {
                        if (identifiers.contains(file[i])) {
                            identifiersCopy.remove(file[i]);
                        }
                    }
                    return identifiersCopy.isEmpty();
                } catch (IOException e) {
                    return false;
                }
            };
        }
    }
}
