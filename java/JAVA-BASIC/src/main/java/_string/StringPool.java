package _string;

public class StringPool {

    public static void main(String[] args) {

        String str1 = new String("abc");
        String str2 = "abc";

        if (str1 == str2) {
            System.out.println("  str1  ====  str2 ");
        } else {
            System.out.println("  str1 !=== str2  ");
        }

        String str3 = str2.intern();

        if (str2 == str1.intern()) {
            System.out.println("  str1  ====  str2 ");
        } else {
            System.out.println("  str1 !=== str2  ");
        }
        
    }

}
