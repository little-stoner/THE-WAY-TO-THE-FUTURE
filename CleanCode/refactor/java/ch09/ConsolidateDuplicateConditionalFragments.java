package refactor.java.ch09;

public class ConsolidateDuplicateConditionalFragments {
    public void ex() {
        if (isSpecialDeal()) {
            total = price * 0.95;
            send();
        } else {
            total = price * 0.98;
             send();
        }
    }
    public void after() {
        if (isSpecialDeal()) {
            total = price * 0.95;
        } else {
            total = price * 0.98;
        }
        send();
    }
}
