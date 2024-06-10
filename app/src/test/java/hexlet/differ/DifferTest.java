package hexlet.differ;

import hexlet.code.differ.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class DifferTest {
//    static String resultOfGenerateJson;
//    static String resultOfGenerateWithFirstFileWithEmptyValueInJSON;
//    static String resultOfGenerateWithSecondFileWithEmptyValueInJSON;
//    static String resultOfGenerateYaml;
//
//    @BeforeAll
//    public static void createResult() {
//        resultOfGenerateJson = "{\n"
//                + "  - follow: false\n"
//                + "    host: hexlet.io\n"
//                + "  - proxy: 123.234.53.22\n"
//                + "  - timeout: 50\n"
//                + "  + timeout: 20\n"
//                + "  + verbose: true\n}";
//
//        resultOfGenerateWithFirstFileWithEmptyValueInJSON = "{\n"
//                + "  + host: hexlet.io\n"
//                + "  + timeout: 20\n"
//                + "  + verbose: true\n}";
//
//        resultOfGenerateWithSecondFileWithEmptyValueInJSON = "{\n"
//                + "  - host: hexlet.io\n"
//                + "  - timeout: 20\n"
//                + "  - verbose: true\n}";
//
//        resultOfGenerateYaml = "{\n"
//                + "  - age: 15\n"
//                + "  + age: 17\n"
//                + "  - friends: [Ivan, John, Robert]\n"
//                + "  + friends: [Roman, Anya, Fedor]\n"
//                + "    group: 5\n"
//                + "  - lastName: Irbi\n"
//                + "  + lastName: Ruby\n"
//                + "  - name: Vova\n"
//                + "  + name: Pasha\n}";
//    }
//
//    @Test
//    public void testGenerateJson() {
//        var resultFromFunction = Assertions.assertDoesNotThrow(
//                () -> Differ.generate("src/test/resources/json/FullValue1.json",
//                        "src/test/resources/json/FullValue2.json"));
//        Assertions.assertEquals(
//                DifferTest.resultOfGenerateJson,
//                resultFromFunction);
//    }
//
//    @Test
//    public void testGenerateYaml() {
//        var result = Assertions.assertDoesNotThrow(
//                () -> Differ.generate("src/test/resources/yaml/FullValue1.yaml",
//                        "src/test/resources/yaml/FullValue2.yaml"));
//        Assertions.assertEquals(DifferTest.resultOfGenerateYaml, result);
//    }
//
//    @Test
//    public void testGenerateWithEmptyValueInJSON() {
//        var resultFromFunction = Assertions.assertDoesNotThrow(
//                () -> Differ.generate("src/test/resources/json/EmptyValue.json",
//                        "src/test/resources/json/FullValue2.json"));
//        Assertions.assertEquals(
//                DifferTest.resultOfGenerateWithFirstFileWithEmptyValueInJSON,
//                resultFromFunction);
//
//        var resultFromFunction1 = Assertions.assertDoesNotThrow(
//                () -> Differ.generate("src/test/resources/json/FullValue2.json",
//                        "src/test/resources/json/EmptyValue.json"));
//        Assertions.assertEquals(
//                DifferTest.resultOfGenerateWithSecondFileWithEmptyValueInJSON,
//                resultFromFunction1);
//
//        var resultFromFunction2 = Assertions.assertDoesNotThrow(
//                () -> Differ.generate("src/test/resources/json/EmptyValue.json",
//                        "src/test/resources/json/EmptyValue.json"));
//        Assertions.assertEquals(
//                "Your files are empty!",
//                resultFromFunction2);
//    }
//
//    @Test
//    public void testGenerateWithEmptyFile() {
//        Assertions.assertThrows(
//                Exception.class,
//                () -> Differ.generate("src/test/resources/json/FullValue1.json",
//                        "src/test/resources/json/Empty.json")
//        );
//        Assertions.assertThrows(
//                Exception.class,
//                () -> Differ.generate("src/test/resources/json/Empty.json",
//                        "src/test/resources/json/FullValue1.json")
//        );
//        Assertions.assertThrows(
//                Exception.class,
//                () -> Differ.generate("src/test/resources/json/Empty.json",
//                        "src/test/resources/json/Empty.json")
//        );
//    }
//
//    @Test
//    public void testGenerateWithBadNameFile() {
//        Assertions.assertThrows(
//                Exception.class,
//                () -> Differ.generate("src/test/resources/json/FullValue1.json",
//                        "src/test/resources/json/BadNameFile.json")
//        );
//        Assertions.assertThrows(
//                Exception.class,
//                () -> Differ.generate("src/test/resources/json/BadNameFile.json",
//                        "src/test/resources/json/FullValue1.json")
//        );
//    }
}
