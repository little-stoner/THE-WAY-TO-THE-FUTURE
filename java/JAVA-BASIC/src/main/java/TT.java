import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class TT {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonString = "{\"name\":\"John\", \"age\":20, \"address\":{\"street\":\"Wall Street\", \"city\":\"New York\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        String xmlString = new XmlMapper().writeValueAsString(jsonNode);
        System.out.println(xmlString);
    }
}

