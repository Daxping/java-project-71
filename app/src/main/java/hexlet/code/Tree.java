package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class Tree {
    public static Map<String, String> build(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, String> strMap1 = mapToString(map1);
        Map<String, String> strMap2 = mapToString(map2);
        Map<String, String> resultMap = new HashMap<>();
        resultMap.putAll(strMap1);
        resultMap.putAll(strMap2);
        for (String key : resultMap.keySet()) {
            if (strMap1.containsKey(key) && strMap2.containsKey(key)) {
                if (strMap1.get(key).equals(strMap2.get(key))) {
                    resultMap.put(key,  "same");
                } else {
                    resultMap.put(key, "updated");
                }
            } else if (strMap1.containsKey(key) && !strMap2.containsKey(key)) {
                resultMap.put(key, "removed");
            } else {
                resultMap.put(key, "added");
            }
        }
        return resultMap;
    }

    public static Map<String, String> mapToString(Map<String, Object> map) {
        Map<String, String> stringMap = new HashMap<>();
        for (String key : map.keySet()) {
            if (map.get(key) != null) {
                stringMap.put(key, map.get(key).toString());
            } else {
                stringMap.put(key, "null");
            }
        }
        return stringMap;
    }
}
