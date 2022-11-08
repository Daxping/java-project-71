

package hexlet.code;

import org.apache.commons.lang3.ClassUtils;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Tree {
    public static Map<String, Object> build(Map<String, Object> map1, Map<String, Object> map2) {

        Map<String, Object> result = new LinkedHashMap<>();
        Set<String> keys = getSortedKeys(map1, map2);
        for (String key : keys) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                result.put("- " + key, map1.get(key));
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                result.put("+ " + key, map2.get(key));
            } else if (getDifference(map1, map2, key)) {
                result.put("- " + key, map1.get(key));
                result.put("+ " + key, map2.get(key));
            } else {
                result.put("  " + key, map2.get(key));
            }
        }
        return result;
    }

    public static Set<String> getKeys(Map<String, Object> map) {
        Set<String> keys = new HashSet<>();
        if (map == null) {
            return keys;
        }
        for (Map.Entry<String, Object> pair : map.entrySet()) {
            keys.add(pair.getKey());
        }
        return keys;
    }

    public static Set<String> getSortedKeys(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keys1 = getKeys(map1);
        Set<String> keys2 = getKeys(map2);
        keys1.addAll(keys2);
        return keys1.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static boolean getDifference(Map<String, Object> map1, Map<String, Object> map2, String key) {
        Object value1 = map1.get(key);
        Object value2 = map2.get(key);
        return (value1 == null || value2 == null ? value1 != value2 : !value1.equals(value2));
    }

    public static List<String> convertToPlain(Map<String, Object> map) {
        List<String> list = new LinkedList<>();
        for (Map.Entry<String, Object> pair : map.entrySet()) {
            String key = pair.getKey();
            if (key.contains("- ")) {
                String key2 = changeKey(key, "- ", "+ ");
                if (map.containsKey(key2)) {
                    list.add("Property '" + changeKey(key, "- ", "") + "' was updated. From "
                            + getCurrentValue(map, key) + " to " + getCurrentValue(map, key2));
                } else {
                    list.add("Property '" + changeKey(key, "- ", "") + "' was removed");
                }
            } else if (key.contains("+ ")) {
                String key2 = changeKey(key, "+ ", "- ");
                if (!map.containsKey(key2)) {
                    list.add("Property '" + changeKey(key, "+ ", "") + "' was added with value: "
                            + getCurrentValue(map, key));
                }
            }
        }
        return list;
    }

    public static String changeKey(String key, String target, String replacement) {
        return key.replace(target, replacement);
    }

    public static Object getCurrentValue(Map<String, Object> map, String key) {
        Object currentValue;
        if (map.get(key) == null || ClassUtils.isPrimitiveOrWrapper(map.get(key).getClass())) {
            currentValue = map.get(key);
        } else if (map.get(key) instanceof String) {
            currentValue = "'" + map.get(key) + "'";
        } else {
            currentValue = "[complex value]";
        }
        return currentValue;
    }
}
