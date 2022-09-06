import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {

    private static int search(int[] input, int target) {
        int lo = 0;
        int hi = input.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            System.out.println(" current location " + mid);
            if (target > input[mid]) {
                lo = mid + 1;
            }
            else if (target < input[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] in = new int[] { 1, 2, 3, 4, 5, 6, 7, 9 };
        System.out.println(search(in, 5));
    }
    
}
