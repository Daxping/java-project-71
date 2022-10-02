package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class MapConverter {
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
