package _0practice.vi.string;

public class StringEqualSB {

    public static void main(String[] args) {
        String s1 = "abc";

        StringBuilder sb = new StringBuilder(s1);

        System.out.println(s1.equals(sb));
    }

}
