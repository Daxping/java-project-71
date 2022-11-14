

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

        Map<String, Object> unitedData = new HashMap<>();
        unitedData.putAll(firstFileData);
        unitedData.putAll(secondFileData);

        if (unitedData.size() == 0) {
            return treeOfDifference;
        }

        Set<String> sortedKeys = getSortedKeys(unitedData);

        for (String key : sortedKeys) {
            if (!secondFileData.containsKey(key)) {
                treeOfDifference.add(getNode(key, "deleted", firstFileData.get(key), null));
            } else if (!firstFileData.containsKey(key)) {
                treeOfDifference.add(getNode(key, "added", null, secondFileData.get(key)));
            } else if (firstFileData.containsKey(key) && secondFileData.containsKey(key)) {
                if (firstFileData.get(key) == null || secondFileData.get(key) == null
                        ? firstFileData.get(key) != secondFileData.get(key)
                        : !firstFileData.get(key).equals(secondFileData.get(key))) {

                    treeOfDifference.add(getNode(key, "changed", firstFileData.get(key), secondFileData.get(key)));
                } else {
                    treeOfDifference.add(getNode(key, "unchanged", firstFileData.get(key), secondFileData.get(key)));
                }
            }
        }
        return treeOfDifference;
    }

    public static Map<String, Object> getNode(String key, String status, Object oldValue, Object newValue) {
        Map<String, Object> node = new HashMap<>();
        node.put("key", key);
        node.put("status", status);
        node.put("oldValue", oldValue);
        node.put("newValue", newValue);
        return node;
    }

    public static Set<String> getSortedKeys(Map<String, Object> unitedData) {
        Set<String> keys = new HashSet<>();
        for (String key: unitedData.keySet()) {
            keys.add(key);
        }
        return keys.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
