package hexlet.code.formatters.plain;

import hexlet.code.formatters.Format;

import java.util.*;

public class Plain implements Format {

    @Override
    public String getDataInFormat(Map<String, Object> dataFromFile1, Map<String, Object> dataFromFile2) {
        var setOfSortedKeys = new TreeSet<>(String::compareTo);
        setOfSortedKeys.addAll(dataFromFile1.keySet());
        setOfSortedKeys.addAll(dataFromFile2.keySet());
        var result = new StringBuilder();

        for (var key : setOfSortedKeys) {
            var valueFromFile1 = dataFromFile1.getOrDefault(key, "Value not found");
            var valueFromFile2 = dataFromFile2.getOrDefault(key, "Value not found");

            if (valueFromFile1 == null && valueFromFile2 == null) {
                result.append("");
            } else if (valueFromFile1 == null) {
                if (valueFromFile2.equals("Value not found")) {
                    result.append(String.format("Property '%s' was removed\n", key));
                    continue;
                }
                result.append(String.format("Property '%s' was updated. From %s to %s\n",
                        key,
                        getStringOfValue(valueFromFile1),
                        getStringOfValue(valueFromFile2)));
            } else if (valueFromFile2 == null) {
                if (valueFromFile1.equals("Value not found")) {
                    result.append(String.format("Property '%s' was added with value: %s\n",
                            key,
                            getStringOfValue(valueFromFile2)));
                    continue;
                }
                result.append(String.format("Property '%s' was updated. From %s to %s\n",
                        key,
                        getStringOfValue(valueFromFile1),
                        getStringOfValue(valueFromFile2)));
            } else {
                if (valueFromFile1.equals(valueFromFile2)) {
                    result.append("");
                } else {
                    if (valueFromFile1.equals("Value not found")) {
                        result.append(String.format("Property '%s' was added with value: %s\n",
                                key,
                                getStringOfValue(valueFromFile2)));
                    } else if (valueFromFile2.equals("Value not found")) {
                        result.append(String.format("Property '%s' was removed\n", key));
                    } else {
                        result.append(String.format("Property '%s' was updated. From %s to %s\n",
                                key,
                                getStringOfValue(valueFromFile1),
                                getStringOfValue(valueFromFile2)));
                    }
                }
            }
        }

        return result.toString();
    }

    public static String getStringOfValue(Object value) {
        if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        } else if (value instanceof String) {
            return String.format("'%s'", value);
        }
        else if (value == null) {
            return "null";
        } else {
            return value.toString();
        }
    }
}
