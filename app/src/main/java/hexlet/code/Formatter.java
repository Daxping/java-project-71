package hexlet.code;

import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(
            List<Map<String, Object>> treeOfDifference, String formatName) throws Exception {
        switch (formatName) {
            case "stylish":
                return Stylish.format(treeOfDifference);
            case "plain":
                return Plain.format(treeOfDifference);
            case "json":
                return Json.format(treeOfDifference);
            default:
                throw new Exception("Unknown format: '" + formatName + "'");
        }
    }
}
