package _regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFindText {

    public static void reg() {

        String inputStr = "This is an apple. There are 33 (thirty-three) apples.";

        String regexStr = "Th";
        regexStr = "\\w+";
        regexStr = "\\b[1-9][0-9]+\\b";

        Pattern pattern = Pattern.compile(regexStr);

        Matcher matcher = pattern.matcher(inputStr);

        while (matcher.find()) {
            System.out.println("find() found substring \"" + matcher.group()
                    + "\" starting at index " + matcher.start()
                    + " and ending at index " + matcher.end()
            );
        }

        if (matcher.matches()) {
            System.out.println(
                    "matches() found substring \"" + matcher.group()
                            + "\" starting at index " + matcher.start()
                            + " and ending at index " + matcher.end()
            );
        } else {
            System.out.println("matches() found nothing");
        }

        if (matcher.lookingAt()) {
            System.out.println(
                    "lookingAt() found substring \"" + matcher.group()
                            + "\" starting at index " + matcher.start()
                            + " and ending at index " + matcher.end()
            );
        } else {
            System.out.println("lookingAt() found nothing");
        }
    }

    public static void rege() {
        String inputStr = "This is an apple. There are 33 (thirty-three) apples.";
        String regexStr = "apple";
        String replacementStr = "orange";
        Pattern pattern = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        String outputStr = matcher.replaceFirst(replacementStr);
        System.out.println(outputStr);
    }

    public static void regex() {
        String inputStr = "One:two:three:four";
        String regexStr = "(.+):(.+):(.+):(.+)";
        String replacementStr = "$4-$3-$2-$1";
        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(inputStr);
        while (matcher.find()) {
            System.out.println("find() found substring \"" + matcher.group()
                    + "\" starting at index " + matcher.start()
                    + " and ending at index " + matcher.end());
            System.out.println("Group count is: " + matcher.groupCount());
            for (int i = 0; i < matcher.groupCount(); ++i) {
                System.out.println("Group " + i + ": substring="
                        + matcher.group(i) + ", start=" + matcher.start(i)
                        + ", end=" + matcher.end(i));
            }
        }
        String outputStr = matcher.replaceAll(replacementStr);
        System.out.println(outputStr);

    }

    public static void main(String[] args) {

        regex();

    }


}
