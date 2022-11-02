package hexlet.code;

import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;
import java.util.Map;

public class Formatter {
    public static String format(
            Map<String, Object> map1, Map<String, Object> map2,
            Map<String, String> diffMap, String formatName) throws Exception {
        switch (formatName) {
            case "stylish":
                return Stylish.formatterStylish(map1, map2, diffMap);
            case "plain":
                return Plain.formatterPlain(map1, map2, diffMap);
            case "json":
                return Json.formatterJson(map1, map2, diffMap);
            default:
                throw new Exception("Unknown format: '" + formatName + "'");
        }
    }
}
