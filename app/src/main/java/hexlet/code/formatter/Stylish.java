package hexlet.code.formatter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Stylish {
    public static String formatterStylish(Map<String, Object> map) {
        List<String> list = new LinkedList<>();
        for (Map.Entry<String, Object> pair : map.entrySet()) {
            list.add(pair.getKey() + ": " + pair.getValue());
        }
        return "{\n" + "  " + String.join("\n  ", list) + "\n}";
    }
}
