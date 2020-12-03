package _housekeeping;

class Rock {
    Rock() {
        System.out.println(" Rock ");
    }
}

public class SimpleConstructor {
    public static void main(String[] args) {
        for (int i=0; i < 4; i++) {
            new Rock();
        }
    }
}
