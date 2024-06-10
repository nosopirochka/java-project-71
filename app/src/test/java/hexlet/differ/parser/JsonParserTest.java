package hexlet.differ.parser;

import hexlet.code.differ.parser.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonParserTest {

    public static JsonParser jsonParser = new JsonParser();
    public static Map<String, Object> resultOfGetData = Map.of(
            "timeout", 20,
            "verbose", true,
            "host", "hexlet.io");

    @Test
    public void testGetDataFromFile() {
        Map<String, Object> dataFromFile = Assertions.assertDoesNotThrow(
                () -> jsonParser.getData("src/test/resources/json/FullValue2.json"));
        Assertions.assertEquals(dataFromFile, JsonParserTest.resultOfGetData);
    }

    @Test
    public void testGetDataFromFileWithEmptyJSONInFile() {
        Map<String, Object> dataFromFile = Assertions.assertDoesNotThrow(
                () -> jsonParser.getData("src/test/resources/json/EmptyValue.json"));
        Assertions.assertEquals(dataFromFile, Map.of());
    }

    @Test
    public void testGetDataFromFileWithEmptyFile() {
        Assertions.assertThrows(Exception.class, () -> jsonParser.getData("src/test/resources/json/Empty.json"));
    }

    @Test
    public void testGetDataFromFileWithBadFileName() {
        Assertions.assertThrows(Exception.class,
                () -> jsonParser.getData("src/test/resources/json/BadFileName.json"));
    }
}
