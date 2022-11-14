package hexlet.code.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Json {
    public static String format(List<Map<String, Object>> treeOfDifference)
            throws Exception {
        Map<String, Object> listOfNodes = new LinkedHashMap<>();

        for (Map<String, Object> node : treeOfDifference) {
            String status = node.get("status").toString();
            switch (status) {
                case "deleted":
                    listOfNodes.put("- " + node.get("key"), node.get("oldValue"));
                    break;
                case "added":
                    listOfNodes.put("+ " + node.get("key"), node.get("newValue"));
                    break;
                case "changed":
                    listOfNodes.put("- " + node.get("key"), node.get("oldValue"));
                    listOfNodes.put("+ " + node.get("key"), node.get("newValue"));
                    break;
                case "unchanged":
                    listOfNodes.put("  " + node.get("key"), node.get("oldValue"));
                    break;
                default:
                    throw new Exception("Unexpected value: " + node.get("status"));
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(listOfNodes);
    }
}
