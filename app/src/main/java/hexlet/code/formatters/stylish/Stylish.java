package hexlet.code.formatters.stylish;

import hexlet.code.formatters.Format;

import java.util.Map;
import java.util.TreeSet;

public class Stylish implements Format {
    @Override
    public String getDataInFormat(Map<String, Object> dataFromFile1, Map<String, Object> dataFromFile2) {
        var setOfSortedKeys = new TreeSet<>(String::compareTo);
        setOfSortedKeys.addAll(dataFromFile1.keySet());
        setOfSortedKeys.addAll(dataFromFile2.keySet());
        var result = new StringBuilder("{\n");

        for (var key : setOfSortedKeys) {
            var valueFromFile1 = dataFromFile1.getOrDefault(key, "Value not found");
            var valueFromFile2 = dataFromFile2.getOrDefault(key, "Value not found");

            if (valueFromFile1 == null && valueFromFile2 == null) {
                result.append(String.format("    %s: %s\n", key, valueFromFile1));
            } else if (valueFromFile1 == null) {
                if (valueFromFile2.equals("Value not found")) {
                    result.append(String.format("  - %s: %s\n", key, valueFromFile1));
                    continue;
                }
                result.append(String.format("  - %s: %s\n", key, valueFromFile1));
                result.append(String.format("  + %s: %s\n", key, valueFromFile2));
            } else if (valueFromFile2 == null){
                if (valueFromFile1.equals("Value not found")) {
                    result.append(String.format("  + %s: %s\n", key, valueFromFile2));
                    continue;
                }
                result.append(String.format("  - %s: %s\n", key, valueFromFile1));
                result.append(String.format("  + %s: %s\n", key, valueFromFile2));
            } else {
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
        }
        result.append("}");

        return result.toString();
    }
}
