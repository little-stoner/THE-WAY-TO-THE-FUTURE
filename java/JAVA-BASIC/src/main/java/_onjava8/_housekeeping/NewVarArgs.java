package _onjava8._housekeeping;

public class NewVarArgs {
    static void printArray(Object... args) {
        for (Object obj : args) {
            System.out.print( obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printArray((Object[])new Integer[]{1, 2, 3, 4 });
        printArray();
    }
}
