package hexlet.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Tree {
    public static List<Map<String, Object>> build(Map<String, Object> firstFileData,
                                                  Map<String, Object> secondFileData) {
        List<Map<String, Object>> treeOfDifference = new LinkedList<>();

        Set<String> sortedKeys = getSortedKeys(firstFileData, secondFileData);

        for (String key : sortedKeys) {
            if (!secondFileData.containsKey(key)) {
                treeOfDifference.add(createNode(key, "deleted", firstFileData.get(key), null));
            } else if (!firstFileData.containsKey(key)) {
                treeOfDifference.add(createNode(key, "added", null, secondFileData.get(key)));
            } else {
                if (!isEqual(firstFileData.get(key), secondFileData.get(key))) {
                    treeOfDifference.add(createNode(key, "changed", firstFileData.get(key), secondFileData.get(key)));
                } else {
                    treeOfDifference.add(createNode(key, "unchanged", firstFileData.get(key), secondFileData.get(key)));
                }
            }
        }
        return treeOfDifference;
    }

    public static Map<String, Object> createNode(String key, String status, Object oldValue, Object newValue) {
        Map<String, Object> node = new HashMap<>();
        node.put("key", key);
        node.put("status", status);
        node.put("oldValue", oldValue);
        node.put("newValue", newValue);
        return node;
    }

    public static Set<String> getSortedKeys(Map<String, Object> firstFileData,
                                            Map<String, Object> secondFileData) {
        Set<String> keys = new HashSet<>();

        Map<String, Object> unitedData = new HashMap<>();
        unitedData.putAll(firstFileData);
        unitedData.putAll(secondFileData);

        if (unitedData.size() == 0) {
            return keys;
        }

        for (String key: unitedData.keySet()) {
            keys.add(key);
        }
        return keys.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static boolean isEqual(Object value1, Object value2) {
        if (value1 == null || value2 == null) {
            return value1 == value2;
        }

        return value1.equals(value2);
    }

}
