package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Json {
    public static String formatterJson(Map<String, Object> map1,
                                       Map<String, Object> map2, Map<String, String> diffMap)
            throws JsonProcessingException {

        List<String> keyList = new ArrayList<>(diffMap.keySet());
        Collections.sort(keyList);
        Map<String, Object> resultMap = new HashMap<>();
        for (String key : keyList) {
            switch (diffMap.get(key)) {
                case "same":
                    resultMap.put("  " + key, map2.get(key));
                    break;
                case "updated":
                    resultMap.put("- " + key, map1.get(key));
                    resultMap.put("+ " + key, map2.get(key));
                    break;
                case "removed":
                    resultMap.put("- " + key, map1.get(key));
                    break;
                case "added":
                    resultMap.put("+ " + key, map2.get(key));
                    break;
                default:
                    System.out.println("Unknown value");
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(resultMap);
    }
}
