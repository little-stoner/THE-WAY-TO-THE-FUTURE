package _concurrent.completable;

public class TestStaticIDField {
    public static void main(String[] args) {
        IDChecker.test(StaticIDField::new);
        IDChecker.test(GuardedIDField::new);
    }
}
