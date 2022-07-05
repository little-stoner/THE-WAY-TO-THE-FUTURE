package refactor.java.ch09;

public class ReplaceNestedConditionalWithGuardClauses {
    double getPayAmount() {
        double result;
        if (_isDead)
            result = deadAmount();
        else {
            if (_isSeparated)
                result = separatedAmount();
            else {
                if (_isRetired)
                    result = retiredAmount();
                else
                    result = normalPayAmount();
            }
            ;
        }
        return result;
    };

    double getPayAmount() {
        if (_isDead)
            return deadAmount();
        if (_isSeparated)
            return separatedAmount();
        if (_isRetired)
            return retiredAmount();
        return normalPayAmount();
    }

    public double getAdjustedCapital() {
        double result = 0.0;
        if (_capital > 0.0) {
            if (_intRate > 0.0 && _duration > 0.0) {
                result = (_income / _duration) * ADJ_FACTOR;
            }
        }
        return result;
    }

    public double getAdjustedCapital() {
        double result = 0.0;
        if (_capital <= 0.0)
            return result;
        if (_intRate <= 0.0 || _duration <= 0.0)
            return result;
        result = (_income / _duration) * ADJ_FACTOR;
        return result;
    }

    public double getAdjustedCapital() {
        if (_capital <= 0.0)
            return 0.0;
        if (_intRate <= 0.0 || _duration <= 0.0)
            return 0.0;
        return (_income / _duration) * ADJ_FACTOR;
    }
}
