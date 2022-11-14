package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String fileContent, String format) throws Exception {
        switch (format) {
            case "json":
                return parseJson(fileContent);
            case "yml":
            case "yaml":
                return parseYaml(fileContent);
            default:
                throw new Exception("Unknown file format: '" + format + "'");
        }
    }

    public static Map<String, Object> parseJson(String str) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(str, new TypeReference<>() {
        });
    }

    public static Map<String, Object> parseYaml(String str) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(str, new TypeReference<>() {
        });
    }
}






