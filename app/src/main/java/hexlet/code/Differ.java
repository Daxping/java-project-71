package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import static hexlet.code.Parser.parse;

public class Differ {
    public static String generate(String path1, String path2, String formatName) throws Exception {
        Map<String, Object> firstFileData = getData(path1);
        Map<String, Object> secondFileData = getData(path2);
        List<Map<String, Object>> treeOfDifference = Tree.build(firstFileData, secondFileData);
        return Formatter.format(treeOfDifference, formatName);
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }

    public static Path getAbsolutePath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    public static Map<String, Object> getData(String path) throws Exception {
        String fileFormat = path.substring(path.lastIndexOf(".") + 1);
        Path absolutePath = getAbsolutePath(path);
        byte[] fileContent = Files.readAllBytes(absolutePath);
        String content = new String(fileContent);
        return parse(content, fileFormat);
    }
}
