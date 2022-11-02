package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.util.Map;
import java.io.File;

public class Parser {
    public static Map<String, Object> jsonParsing(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, new TypeReference<>() { });
    }

    public static Map<String, Object> yamlParsing(File file) throws IOException {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(file, new TypeReference<>() { });
    }
}
