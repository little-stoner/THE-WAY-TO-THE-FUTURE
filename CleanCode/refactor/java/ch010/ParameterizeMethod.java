package refactor.java.ch010;

public class ParameterizeMethod {
    protected Dollars baseCharge() {
        double result = Math.min(lastUsage(), 100) * 0.03;
        if (lastUsage() > 100) {
            result += (Math.min(lastUsage(), 200) - 100) * 0.05;
        }
        ;
        if (lastUsage() > 200) {
            result += (lastUsage() - 200) * 0.07;
        }
        ;
        return new Dollars(result);
    }

    protected Dollars baseCharge() {
        double result = usageInRange(0, 100) * 0.03;
        result += usageInRange(100, 200) * 0.05;
        result += usageInRange(200, Integer.MAX_VALUE) * 0.07;

        return new Dollars(result);
    }

    protected int usageInRange(int start, int end) {
        if (lastUsage() > start)
            return Math.min(lastUsage(), end) -
                    start;
        else
            return 0;
    }
}
