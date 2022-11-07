package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import static hexlet.code.Parser.parse;
import static hexlet.code.Tree.build;

public class Differ {
    public static String generate(String path1, String path2, String formatName) throws Exception {
        Map<String, Object> map1 = getData(path1);
        Map<String, Object> map2 = getData(path2);
        Map<String, Object> map = build(map1, map2);
        return Formatter.format(map, formatName);
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }

    public static Path getAbsolutePath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    public static Map<String, Object> getData(String path) throws Exception {
        String fileFormat = "";
        if (path.endsWith(".json")) {
            fileFormat = "json";
        } else if (path.endsWith(".yml")) {
            fileFormat = "yml";
        }
        return parse(new String(Files.readAllBytes(getAbsolutePath(path))), fileFormat);
    }
}
