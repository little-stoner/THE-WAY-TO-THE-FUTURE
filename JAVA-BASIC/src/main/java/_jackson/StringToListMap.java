package _jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class StringToListMap {
    public static void main(String[] args) {
        String a = "[{\n" +
                "                \"amount\": 60.06,\n" +
                "                \"transactionMode\": 15000,\n" +
                "                \"transactionStatus\": 3,\n" +
                "                \"changeType\": 0,\n" +
                "                \"flags\": 1,\n" +
                "                \"transactionNo\": \"6938200\",\n" +
                "                \"transactionDate\": 1550811600000,\n" +
                "                \"principal\": 1.53,\n" +
                "                \"transactionType\": 14001,\n" +
                "                \"interest\": 58.53,\n" +
                "                \"lateFee\": 0.00,\n" +
                "                \"id\": 17806873,\n" +
                "                \"applicationId\": 533245,\n" +
                "                \"nsfFee\": 0.00,\n" +
                "                \"scheduleId\": 523408,\n" +
                "                \"achProviderId\": 4\n" +
                "        },\n" +
                "        {\n" +
                "            \"amount\": 56.28,\n" +
                "                \"transactionMode\": 15000,\n" +
                "                \"transactionStatus\": 3,\n" +
                "                \"changeType\": 0,\n" +
                "                \"flags\": 1,\n" +
                "                \"transactionNo\": \"6984597\",\n" +
                "                \"transactionDate\": 1550811600000,\n" +
                "                \"principal\": 1.29,\n" +
                "                \"transactionType\": 14001,\n" +
                "                \"interest\": 54.99,\n" +
                "                \"lateFee\": 0.00,\n" +
                "                \"id\": 17806913,\n" +
                "                \"applicationId\": 533246,\n" +
                "                \"nsfFee\": 0.00,\n" +
                "                \"scheduleId\": 523409,\n" +
                "                \"achProviderId\": 3\n" +
                "        }]";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Map<String, Object>> data = objectMapper.readValue(a, new TypeReference<List<Map<String, Object>>>(){});
            System.out.println(">>>>>>>>>>>> " + data);
        } catch (Exception e) {}
    }
}
