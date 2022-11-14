package hexlet.code.formatter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> treeOfDifference) throws Exception {

        List<String> listOfNodes = new LinkedList<>();

        for (Map<String, Object> node : treeOfDifference) {
            String status = node.get("status").toString();
            switch (status) {
                case "deleted":
                    listOfNodes.add("- " + node.get("key") + ": " + node.get("oldValue"));
                    break;
                case "added":
                    listOfNodes.add("+ " + node.get("key") + ": " + node.get("newValue"));
                    break;
                case "changed":
                    listOfNodes.add("- " + node.get("key") + ": " + node.get("oldValue"));
                    listOfNodes.add("+ " + node.get("key") + ": " + node.get("newValue"));
                    break;
                case "unchanged":
                    listOfNodes.add("  " + node.get("key") + ": " + node.get("oldValue"));
                    break;
                default:
                    throw new Exception("Unexpected value: " + node.get("status"));
            }
        }
        return "{\n" + "  " + String.join("\n  ", listOfNodes) + "\n}";
    }
}
