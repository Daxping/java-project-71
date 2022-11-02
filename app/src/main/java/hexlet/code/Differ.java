package hexlet.code;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import static hexlet.code.Parser.jsonParsing;
import static hexlet.code.Parser.yamlParsing;
import static hexlet.code.Tree.build;

public class Differ {
    public static String generate(String path1, String path2, String formatName) throws Exception {
        Map<String, Object> map1 = getData(path1);
        Map<String, Object> map2 = getData(path2);
        Map<String, String> diffMap = build(map1, map2);
        return Formatter.format(map1, map2, diffMap, formatName);
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }

    public static Map<String, Object> getData(String path) throws Exception {
        File file = new File(path);
        Map<String, Object> map = new HashMap<>();
        if (path.endsWith(".json")) {
            map.putAll(jsonParsing(file));
        } else if (path.endsWith(".yml")) {
            map.putAll(yamlParsing(file));
        }
        return map;
    }
}
