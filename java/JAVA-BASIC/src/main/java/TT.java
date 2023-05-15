import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;

public class TT {

    private static class A {}

    public static void main(String[] args) {
        A a = JSONObject.parseObject("", A.class);
        System.out.println(a);
    }
}

