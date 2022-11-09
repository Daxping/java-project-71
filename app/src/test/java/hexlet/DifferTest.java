package hexlet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DifferTest {

    @Test
    public void testJsonWhithoutFormat() throws Exception {
        String result = readFixture("testStylish.txt");
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.json",
                "./src/test/resources/testFile2.json"));
    }

    @Test
    public void testJsonStylish() throws Exception {
        String result = readFixture("testStylish.txt");
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.json",
                "./src/test/resources/testFile2.json", "stylish"));
    }

    @Test
    public void testYAMLStylish() throws Exception {
        String result = readFixture("testStylish.txt");
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.yml",
                "./src/test/resources/testFile2.yml", "stylish"));
    }

    @Test
    public void testJsonPlain() throws Exception {
        String result = readFixture("testPlain.txt");
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.json",
                "./src/test/resources/testFile2.json", "plain"));
    }

    @Test
    public void testYAMLPlain() throws Exception {
        String result = readFixture("testPlain.txt");
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.yml",
                "./src/test/resources/testFile2.yml", "plain"));
    }

    @Test
    public void testYAMLJson() throws Exception {
        String result = readFixture("testJson.txt");
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.yml",
                "./src/test/resources/testFile2.yml", "json"));
    }

    @Test
    public void testJsonJson() throws Exception {
        String result = readFixture("testJson.txt");
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.json",
                "./src/test/resources/testFile2.json", "json"));
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

}
