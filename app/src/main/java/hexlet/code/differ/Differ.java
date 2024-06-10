package hexlet.code.differ;

import hexlet.code.differ.parser.Parser;
import hexlet.code.differ.parser.JsonParser;
import hexlet.code.differ.parser.YamlParser;
import hexlet.code.formatters.Formatter;

public class Differ {

    public static final Formatter FORMATTER = new Formatter();

    public static String generate(String pathForFile1, String pathForFile2, String nameOfFormat) throws Exception {
        var method = getTypeOfParse(pathForFile1, pathForFile2);
        var dataFromFile1 = method.getData(pathForFile1);
        var dataFromFile2 = method.getData(pathForFile2);
        if (dataFromFile1.isEmpty() && dataFromFile2.isEmpty()) {
            return "Your files are empty!";
        }
        var format = FORMATTER.getFormat(nameOfFormat);
        return format.getDataInFormat(dataFromFile1, dataFromFile2);
    }

    public static Parser getTypeOfParse(String path1, String path2) throws Exception {
        if ((path1.endsWith("yaml") && path2.endsWith("yaml")) || (path1.endsWith("yml") && path2.endsWith("yml"))) {
            return new YamlParser();
        } else if (path1.endsWith("json") && path2.endsWith("json")) {
            return new JsonParser();
        }
        throw new RuntimeException();
    }
}
