
public class Reverse {

    public static void reverse(int[] input) {
        // assertNotEmpty(input);
        int len = input.length;
        for (int i=0; i < len/2; i++) {
            int a = input[i];
            int b = input[len-1-i];
            input[i] = b;
            input[len-1-i] = a;
        }
        for (int i=0; i < len; i++) {
            System.out.println(input[i]);
        }
        
    }

    public static void main(String[] args) {
        Reverse.reverse(new int[] { 1, 2, 3, 4, 5 });
    }
    
}
