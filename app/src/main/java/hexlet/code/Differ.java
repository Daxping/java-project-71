package hexlet.code;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Differ {
    public static String generate(String path1, String path2, String formatName) throws IOException {
        Map<String, Object> map1 = Parser.parsing(path1);
        Map<String, Object> map2 = Parser.parsing(path2);

        String result = Formatter.chooseFormat(map1, map2, formatName);
        System.out.println(result);

        return result;
    }

    public static Map<String, String> differ(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, String> strMap1 = MapConverter.mapToString(map1);
        Map<String, String> strMap2 = MapConverter.mapToString(map2);

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
}
