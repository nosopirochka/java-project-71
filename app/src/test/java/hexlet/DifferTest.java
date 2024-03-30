package hexlet;

import hexlet.code.Differ.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Map;


public class DifferTest {
    static String resultOfGenerate;
    static Map<String, Object> resultOfGetData;
    static String resultOfGenerateWithFirstFileWithEmptyValueInJSON;
    static String resultOfGenerateWithSecondFileWithEmptyValueInJSON;


    @BeforeAll
    public static void createResult() {
        resultOfGenerate = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n}";

        resultOfGetData = Map.of(
                "timeout", 20,
                "verbose", true,
                "host", "hexlet.io");

        resultOfGenerateWithFirstFileWithEmptyValueInJSON = "{\n"
                + "  + host: hexlet.io\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n}";
        resultOfGenerateWithSecondFileWithEmptyValueInJSON = "{\n"
                + "  - host: hexlet.io\n"
                + "  - timeout: 20\n"
                + "  - verbose: true\n}";
    }

    @Test
    public void testGenerate() {
        var resultFromFunction = Assertions.assertDoesNotThrow(
                () -> Differ.generate("src/test/resources/FullValue1", "src/test/resources/FullValue2"));
        Assertions.assertEquals(
                DifferTest.resultOfGenerate,
                resultFromFunction);
    }

    @Test
    public void testGenerateWithEmptyValueInJSON() {
        var resultFromFunction = Assertions.assertDoesNotThrow(
                () -> Differ.generate("src/test/resources/EmptyValue", "src/test/resources/FullValue2"));
        Assertions.assertEquals(
                DifferTest.resultOfGenerateWithFirstFileWithEmptyValueInJSON,
                resultFromFunction);

        var resultFromFunction1 = Assertions.assertDoesNotThrow(
                () -> Differ.generate("src/test/resources/FullValue2", "src/test/resources/EmptyValue"));
        Assertions.assertEquals(
                DifferTest.resultOfGenerateWithSecondFileWithEmptyValueInJSON,
                resultFromFunction1);

        var resultFromFunction2 = Assertions.assertDoesNotThrow(
                () -> Differ.generate("src/test/resources/EmptyValue", "src/test/resources/EmptyValue"));
        Assertions.assertEquals(
                "Your JSON in files are empty!",
                resultFromFunction2);
    }

    @Test
    public void testGenerateWithEmptyFile() {
        Assertions.assertThrows(
                Exception.class,
                () -> Differ.generate("src/test/resources/FullValue1", "src/test/resources/Empty")
        );
        Assertions.assertThrows(
                Exception.class,
                () -> Differ.generate("src/test/resources/Empty", "src/test/resources/FullValue1")
        );
        Assertions.assertThrows(
                Exception.class,
                () -> Differ.generate("src/test/resources/Empty", "src/test/resources/Empty")
        );
    }

    @Test
    public void testGenerateWithBadNameFile() {
        Assertions.assertThrows(
                Exception.class,
                () -> Differ.generate("src/test/resources/FullValue1", "src/test/resources/BadNameFile")
        );
        Assertions.assertThrows(
                Exception.class,
                () -> Differ.generate("src/test/resources/BadNameFile", "src/test/resources/FullValue1")
        );
    }

    @Test
    public void testGetDataFromFile() {
        Map<String, Object> dataFromFile = Assertions.assertDoesNotThrow(
                () -> Differ.getDataFromFile("src/test/resources/FullValue2"));
        Assertions.assertEquals(dataFromFile, DifferTest.resultOfGetData);
    }

    @Test
    public void testGetDataFromFileWithEmptyJSONInFile() {
        Map<String, Object> dataFromFile = Assertions.assertDoesNotThrow(
                () -> Differ.getDataFromFile("src/test/resources/EmptyValue"));
        Assertions.assertEquals(dataFromFile, Map.of());
    }

    @Test
    public void testGetDataFromFileWithEmptyFile() {
        Assertions.assertThrows(Exception.class, () -> Differ.getDataFromFile("src/test/resources/Empty"));
    }

    @Test
    public void testGetDataFromFileWithBadFileName() {
        Assertions.assertThrows(Exception.class, () -> Differ.getDataFromFile("src/test/resources/BadFileName"));
    }
}
