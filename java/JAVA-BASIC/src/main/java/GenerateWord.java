import com.deepoove.poi.XWPFTemplate;

import java.io.IOException;
import java.util.HashMap;

public class GenerateWord {

    public static void main(String[] args) throws IOException {

        XWPFTemplate.compile(
                "/Users/viber/Documents/template.docx"
        ).render(
                new HashMap<String, Object>() {{
                    put("no", "MD-007");
                    put("count", 1);
                    put("address", "china");
                    put("username", "Simon");
                    put("apply", "xie");
                    put("date", "12/2/2020");
                    put("iconName", "KKK");
                    put("number", "qwer");
                }}
        ).writeToFile(
                "/Users/viber/Documents/template0.docx"
        );


    }

}
