package edu.hw6;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Task1 {

    public static class DiskMap implements Map<String, String> {

        public static final String ROOT_DIR = "C:/Users/mrpop/java-course-2023/project-template/";
        public static final String PATH_TO_MAPS = "src/main/java/edu/hw6/task1Sources";
        private static final ObjectMapper OBJ_MAPPER = new ObjectMapper();
        private final HashMap<String, String> actualMap;
        List<String> unsavedAfterLastDump;
        private Path storagePath;
        private int statusOfLastDump;

        private void setStorage(Path path) {
            if (Files.isDirectory(path)) {
                try {
                    storagePath = path.resolve("mapNumber" + UUID.randomUUID() + ".json");
                    Files.createFile(storagePath);

                } catch (IOException exc) {
                    storagePath = null;
                }
            } else {
                storagePath = path;
            }
        }

        public DiskMap(boolean createStorage) {
            actualMap = new HashMap<>();
            unsavedAfterLastDump = new ArrayList<>();
            if (createStorage) {
                setStorage(Paths.get(ROOT_DIR, PATH_TO_MAPS));
            }
        }

        public Path getStoragePath() {
            return storagePath;
        }

        public static DiskMap uploadAndUseOldStorage(Path path) {
            DiskMap resultMap = new DiskMap(false);
            resultMap.storagePath = path;
            try {
                String jsons = Files.readString(resultMap.storagePath);
                resultMap.actualMap.putAll(OBJ_MAPPER.readValue(jsons, JSONforHashMap.class).toHashMap());
                return resultMap;
            } catch (IOException exc) {
                return resultMap;
            }
        }

        public void dump() {
            JSONforHashMap tempObj = new JSONforHashMap(
                actualMap.size(),
                actualMap.keySet().toArray(new String[0]),
                actualMap.values().toArray(new String[0])
            );
            try {
                String fullTextOfFile = OBJ_MAPPER.writeValueAsString(tempObj);
                Files.deleteIfExists(storagePath);
                Files.createFile(storagePath);
                Files.writeString(storagePath, fullTextOfFile);
            } catch (IOException exc) {
                statusOfLastDump = -1;
                return;
            }
            statusOfLastDump = 1;
        }

        public int getStatusOfLastDump() {
            return statusOfLastDump;
        }

        @Override public int size() {
            return actualMap.size();
        }

        @Override public boolean isEmpty() {
            return actualMap.isEmpty();
        }

        @Override public boolean containsKey(Object key) {
            return actualMap.containsKey(key);
        }

        @Override public boolean containsValue(Object value) {
            return actualMap.containsValue(value);
        }

        @Override public String get(Object key) {
            return actualMap.get(key);
        }

        @Nullable @Override public String put(String key, String value) {
            return actualMap.put(key, value);
        }

        @Override public String remove(Object key) {
            return actualMap.remove(key);
        }

        @Override public void putAll(@NotNull Map<? extends String, ? extends String> m) {

            actualMap.putAll(m);
        }

        @Override public void clear() {
            actualMap.clear();
        }

        @NotNull @Override public Set<String> keySet() {
            return actualMap.keySet();
        }

        @NotNull @Override public Collection<String> values() {
            return actualMap.values();
        }

        @Override public @NotNull Set<Entry<String, String>> entrySet() {
            return actualMap.entrySet();
        }

        record JSONforHashMap(int size, String[] keys, String[] values) {
            HashMap<String, String> toHashMap() {
                HashMap<String, String> result = new HashMap<>();
                for (int i = 0; i < size; ++i) {
                    result.put(keys[i], values[i]);
                }
                return result;
            }
        }
    }
}
