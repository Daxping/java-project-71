package hexlet.code.formatter;

import hexlet.code.Tree;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(Map<String, Object> map) {

        List<String> list = new LinkedList<>(Tree.convertToPlain(map));

        return String.join("\n", list);
    }
}

