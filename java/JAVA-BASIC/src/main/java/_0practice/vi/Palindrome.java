package _0practice.vi;

public class Palindrome {


    public boolean palindrome(String input) {
        int length = input.length();
        if (length == 0) return false;
        for ( int i=0; i < length/2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
