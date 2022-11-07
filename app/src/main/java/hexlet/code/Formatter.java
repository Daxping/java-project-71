package hexlet.code;

import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;
import java.util.Map;

public class Formatter {
    public static String format(
            Map<String, Object> map, String formatName) throws Exception {
        switch (formatName) {
            case "stylish":
                return Stylish.formatterStylish(map);
            case "plain":
                return Plain.formatterPlain(map);
            case "json":
                return Json.formatterJson(map);
            default:
                throw new Exception("Unknown format: '" + formatName + "'");
        }
    }
}
