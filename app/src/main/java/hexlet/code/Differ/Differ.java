package hexlet.code.Differ;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeSet;

public class Differ {

    public static String generate(String pathForFile1, String pathForFile2) throws Exception {
        var dataFromFile1 = Differ.getDataFromFile(pathForFile1);
        var dataFromFile2 = Differ.getDataFromFile(pathForFile2);
        if (dataFromFile1.isEmpty() && dataFromFile2.isEmpty()) {
            return "Your JSON in files are empty!";
        }
        var setOfSortedKeys = new TreeSet<>(String::compareTo);
        setOfSortedKeys.addAll(dataFromFile1.keySet());
        setOfSortedKeys.addAll(dataFromFile2.keySet());
        var result = new StringBuilder("{\n");

        for (var key : setOfSortedKeys) {
            var valueFromFile1 = dataFromFile1.getOrDefault(key, "Value not found");
            var valueFromFile2 = dataFromFile2.getOrDefault(key, "Value not found");

            if (valueFromFile1.equals(valueFromFile2)) {
                result.append(String.format("    %s: %s\n", key, valueFromFile1));
            } else {
                if (valueFromFile1.equals("Value not found")) {
                    result.append(String.format("  + %s: %s\n", key, valueFromFile2));
                } else if (valueFromFile2.equals("Value not found")) {
                    result.append(String.format("  - %s: %s\n", key, valueFromFile1));
                } else {
                    result.append(String.format("  - %s: %s\n", key, valueFromFile1));
                    result.append(String.format("  + %s: %s\n", key, valueFromFile2));
                }
            }
        }
        result.append("}");

        return result.toString();
    }

    public static Map<String, Object> getDataFromFile(String path) throws Exception {
        Path pathForFile1 = Paths.get(path).toAbsolutePath().normalize();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(pathForFile1.toFile(), new TypeReference<>() { });
    }
}
