package hexlet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DifferTest {

    @Test
    public void testJsonWhithoutFormat() throws IOException {
        String result = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.json",
                "./src/test/resources/testFile2.json"));
    }

    @Test
    public void testJsonStylish() throws IOException {
        String result = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.json",
                "./src/test/resources/testFile2.json", "stylish"));
    }

    @Test
    public void testYAMLStylish() throws IOException {
        String result = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.yml",
                "./src/test/resources/testFile2.yml", "stylish"));
    }

    @Test
    public void testJsonPlain() throws IOException {
        String result = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.json",
                "./src/test/resources/testFile2.json", "plain"));
    }

    @Test
    public void testYAMLPlain() throws IOException {
        String result = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.yml",
                "./src/test/resources/testFile2.yml", "plain"));
    }

    @Test
    public void testYAMLJson() throws IOException {
        String result = "{\"+ id\":null,\"  numbers1\":[1,2,3,4],\"+ numbers4\":[4,5,6],\"- setting2\":200,\""
                + "- setting1\":\"Some value\",\"- default\":null,\"+ numbers2\":[22,33,44,55],\"- setting3\":true,\"  "
                + "chars1\":[\"a\",\"b\",\"c\"],\"+ setting1\":\"Another value\",\"+ checked\":true,\"+ setting2\""
                + ":300,\"+ default\":[\"value1\",\"value2\"],\"+ obj1\":{\"nestedKey\":\"value\",\"isNested\":true},\""
                + "- numbers3\":[3,4,5],\"- id\":45,\"- key1\":\"value1\",\"- chars2\":[\"d\",\"e\",\"f\"],\"+ chars2\""
                + ":false,\"+ key2\":\"value2\",\"- numbers2\":[2,3,4,5],\"+ setting3\":\"none\",\"- checked\":false}";
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.yml",
                "./src/test/resources/testFile2.yml", "json"));
    }

    @Test
    public void testJsonJson() throws IOException {
        String result = "{\"+ id\":null,\"  numbers1\":[1,2,3,4],\"+ numbers4\":[4,5,6],\"- setting2\":200,\""
                + "- setting1\":\"Some value\",\"- default\":null,\"+ numbers2\":[22,33,44,55],\"- setting3\":true,\"  "
                + "chars1\":[\"a\",\"b\",\"c\"],\"+ setting1\":\"Another value\",\"+ checked\":true,\"+ setting2\""
                + ":300,\"+ default\":[\"value1\",\"value2\"],\"+ obj1\":{\"nestedKey\":\"value\",\"isNested\":true},\""
                + "- numbers3\":[3,4,5],\"- id\":45,\"- key1\":\"value1\",\"- chars2\":[\"d\",\"e\",\"f\"],\"+ chars2\""
                + ":false,\"+ key2\":\"value2\",\"- numbers2\":[2,3,4,5],\"+ setting3\":\"none\",\"- checked\":false}";
        assertEquals(result, Differ.generate("./src/test/resources/testFile1.json",
                "./src/test/resources/testFile2.json", "json"));
    }
}
