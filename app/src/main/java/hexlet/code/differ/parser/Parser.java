package hexlet.code.differ.parser;

import java.io.IOException;
import java.util.Map;

public interface Parser {
    Map<String, Object> getData(String path) throws IOException;
}
