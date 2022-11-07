package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String str, String format) throws IOException {
        if (format == "json") {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(str, new TypeReference<>() {
            });
        } else if (format == "yml" || format == "yaml") {
            ObjectMapper mapper = new YAMLMapper();
            return mapper.readValue(str, new TypeReference<>() {
            });
        } else {
            throw new IOException();
        }
    }
}
