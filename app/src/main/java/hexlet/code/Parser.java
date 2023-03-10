package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final ObjectMapper YAML_MAPPER = new YAMLMapper();

    public static Map<String, Object> parse(String content, String format) throws IOException {
        var mapper = switch (format) {
            case "json" -> JSON_MAPPER;
            case "yml", "yaml" -> YAML_MAPPER;
            default -> throw new RuntimeException("Unknown file format: " + format);
        };
        return mapper.readValue(content, new TypeReference<>() {
        });
    }
}
