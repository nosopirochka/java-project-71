package hexlet.code.differ.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class JsonParser implements Parser{

    @Override
    public Map<String, Object> getData(String path) throws IOException {
        Path pathForFile1 = Paths.get(path).toAbsolutePath().normalize();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(pathForFile1.toFile(), new TypeReference<>() { });
    }
}
