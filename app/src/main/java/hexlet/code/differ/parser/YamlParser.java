package hexlet.code.differ.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class YamlParser implements Parser {

    @Override
    public Map<String, Object> getData(String path) throws IOException {
        Path pathForFile = Paths.get(path).toAbsolutePath().normalize();
        ObjectMapper objectMapper = new YAMLMapper();
        return objectMapper.readValue(pathForFile.toFile(), new TypeReference<>() { });
    }
}
