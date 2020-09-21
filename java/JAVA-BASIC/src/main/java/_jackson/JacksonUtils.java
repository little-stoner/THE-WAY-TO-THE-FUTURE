package _jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class JacksonUtils {

    /**
     *
     * @param o
     * @return JSON String
     * @throws https://stackoverflow.com/questions/8367312/serializing-with-jackson-json-getting-no-serializer-found
     */
    public static String toJSONString(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(o);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Optional<String> toString(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return Optional.of(objectMapper.writeValueAsString(o));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
