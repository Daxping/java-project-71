package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;

import java.util.Map;

public class Formatter {
    public static String chooseFormat(
        Map<String, Object> map1, Map<String, Object> map2, String formatName) throws JsonProcessingException {
        switch (formatName) {
            case "stylish":
                return Stylish.formatterStylish(map1, map2);
            case "plain":
                return Plain.formatterPlain(map1, map2);
            case "json":
                return Json.formatterJson(map1, map2);
            default:
                System.out.println("Format" + formatName + "is not correct!");
        }
        return Stylish.formatterStylish(map1, map2);
    }
}
