package hexlet.code.formatter;

import hexlet.code.Differ;
import org.apache.commons.lang3.ClassUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String formatterPlain(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, String> diffMap = Differ.differ(map1, map2);
        List<String> keyList = new ArrayList<>(diffMap.keySet());
        Collections.sort(keyList);

        List<String> resultList = new ArrayList<>();
        for (String key : keyList) {
            switch (diffMap.get(key)) {
                case "same":
                    break;
                case "updated":
                    resultList.add("Property '" + key + "' was updated. From "
                            + getCurrentValue(map1, key) + " to " + getCurrentValue(map2, key));
                    break;
                case "removed":
                    resultList.add("Property '" + key + "' was removed");
                    break;
                case "added":
                    resultList.add("Property '" + key + "' was added with value: " + getCurrentValue(map2, key));
                    break;
                default:
                    System.out.println("Unknown value");
            }
        }

        return String.join("\n", resultList);
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
