package hexlet.code.formatter;

import org.apache.commons.lang3.ClassUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> treeOfDifference) throws Exception {

        List<String> listOfNodes = new LinkedList<>();

        for (Map<String, Object> node : treeOfDifference) {
            String status = node.get("status").toString();
            Object key = node.get("key");
            Object newValue = getCurrentValue(node, "newValue");
            Object oldValue = getCurrentValue(node, "oldValue");

            switch (status) {
                case "deleted":
                    listOfNodes.add("Property '" + key + "' was removed");
                    break;
                case "added":
                    listOfNodes.add("Property '" + key + "' was added with value: "
                            + newValue);
                    break;
                case "changed":
                    listOfNodes.add("Property '" + key +  "' was updated. From " + oldValue + " to " + newValue);
                    break;
                case "unchanged":
                    continue;
                default:
                    throw new Exception("Unexpected value: " + node.get("status"));
            }
        }

        return String.join("\n", listOfNodes);
    }

    public static Object getCurrentValue(Map<String, Object> node, Object key) {
        Object currentValue;
        if (node.get(key) == null || ClassUtils.isPrimitiveOrWrapper(node.get(key).getClass())) {
            currentValue = node.get(key);
        } else if (node.get(key) instanceof String) {
            currentValue = "'" + node.get(key) + "'";
        } else {
            currentValue = "[complex value]";
        }
        return currentValue;
    }
}

