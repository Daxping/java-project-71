package hexlet.code.formatter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import static hexlet.code.Tree.convertToPlain;

public class Plain {
    public static String formatterPlain(Map<String, Object> map) {

        List<String> list = new LinkedList<>(convertToPlain(map));

        return String.join("\n", list);
    }
}

