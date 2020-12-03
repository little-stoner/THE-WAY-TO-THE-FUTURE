package _housekeeping;

class Rock2 {
    Rock2(int i) {
        System.out.println(" Rock " + i + " ");
    }
    {
        System.out.println("=======");
    }
    static {
        System.out.println("xxxxxxxxxxxx");
        System.out.println(new Rock2(0));
    }
}

public class SimpleConstructor2 {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            new Rock2(i);
        }
    }
}
