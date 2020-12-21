package _onjava8._strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(" Regular expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while (m.find()) {
                System.out.println(" Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() -1 ));
            }
        }
    }
}
