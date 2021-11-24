import com.deepoove.poi.XWPFTemplate;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class GenerateWord {

    public static void main(String[] args) throws IOException {

        String yh = "/Users/viber/Documents/yh.xlsx";

        FileInputStream file = new FileInputStream(new File(yh));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            int rc = row.getRowNum();
            if (rc >= 2) {
                Cell cell = row.getCell(1);
                String name = cell.getStringCellValue();
                cell = row.getCell(2);
                String id = cell.getStringCellValue();
                cell = row.getCell(3);
                String phone =  NumberToTextConverter.toText(cell.getNumericCellValue());

                XWPFTemplate.compile(
                        "/Users/viber/Documents/yh0.docx"
                ).render(
                        new HashMap<String, Object>() {{
                            put("name", name);
                            put("id", id);
                            put("phone", phone);
                            put("year", "2021");
                            put("month", "11");
                            put("day", "01");
                        }}
                ).writeToFile(
                        String.format("/Users/viber/Documents/yh/%s.docx", name)
                );
            }
        }


    }

}
