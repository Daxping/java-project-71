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
        String result = readFixture("result_stylish.txt");
        assertEquals(result, Differ.generate("./src/test/resources/fixtures/file1_for_test.json",
                "./src/test/resources/fixtures/file2_for_test.json"));
    }

    @Test
    public void testJsonStylish() throws Exception {
        String result = readFixture("result_stylish.txt");
        assertEquals(result, Differ.generate("./src/test/resources/fixtures/file1_for_test.json",
                "./src/test/resources/fixtures/file2_for_test.json", "stylish"));
    }

    @Test
    public void testYAMLStylish() throws Exception {
        String result = readFixture("result_stylish.txt");
        assertEquals(result, Differ.generate("./src/test/resources/fixtures/file1_for_test.yml",
                "./src/test/resources/fixtures/file2_for_test.yml", "stylish"));
    }

    @Test
    public void testJsonPlain() throws Exception {
        String result = readFixture("result_plain.txt");
        assertEquals(result, Differ.generate("./src/test/resources/fixtures/file1_for_test.json",
                "./src/test/resources/fixtures/file2_for_test.json", "plain"));
    }

    @Test
    public void testYAMLPlain() throws Exception {
        String result = readFixture("result_plain.txt");
        assertEquals(result, Differ.generate("./src/test/resources/fixtures/file1_for_test.yml",
                "./src/test/resources/fixtures/file2_for_test.yml", "plain"));
    }

    @Test
    public void testYAMLJson() throws Exception {
        String result = readFixture("result_json.txt");
        assertEquals(result, Differ.generate("./src/test/resources/fixtures/file1_for_test.yml",
                "./src/test/resources/fixtures/file2_for_test.yml", "json"));
    }

    @Test
    public void testJsonJson() throws Exception {
        String result = readFixture("result_json.txt");
        assertEquals(result, Differ.generate("./src/test/resources/fixtures/file1_for_test.json",
                "./src/test/resources/fixtures/file2_for_test.json", "json"));
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
