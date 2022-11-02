package hexlet.code.formatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Stylish {
    public static String formatterStylish(Map<String, Object> map1,
                                          Map<String, Object> map2, Map<String, String> diffMap) {

        List<String> keyList = new ArrayList<>(diffMap.keySet());
        Collections.sort(keyList);
        List<String> resultList = new ArrayList<>();
        for (String key : keyList) {
            switch (diffMap.get(key)) {
                case "same":
                    resultList.add("  " + key + ": " + map2.get(key));
                    break;
                case "updated":
                    resultList.add("- " + key + ": " + map1.get(key));
                    resultList.add("+ " + key + ": " + map2.get(key));
                    break;
                case "removed":
                    resultList.add("- " + key + ": " + map1.get(key));
                    break;
                case "added":
                    resultList.add("+ " + key + ": " + map2.get(key));
                    break;
                default:
                    System.out.println("Unknown value");
            }
        }
        return "{\n" + "  " + String.join("\n  ", resultList) + "\n}";
    }
}
