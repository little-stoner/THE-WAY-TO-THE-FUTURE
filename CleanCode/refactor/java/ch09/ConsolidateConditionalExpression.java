package refactor.java.ch09;

public class ConsolidateConditionalExpression {
    class Ex {
        double disabilityAmount() {
            if (_seniority < 2)
                return 0;
            if (_monthsDisabled > 12)
                return 0;
            if (_isPartTime)
                return 0;
            // compute the disability amount
        }

        double disabilityAmount() {
            if (isNotEligableForDisability())
                return 0; // compute the disability amount
        }
    }
}
