package refactor.java.ch07;

public class MoveMethod {
    class Account {
        double overdraftCharge() {
            if (_type.isPremium()) {
                double result = 10;
                if (_daysOverdrawn > 7)
                    result += (_daysOverdrawn - 7) * 1.5;
                return result;
            } else {
                return _daysOverdrawn * 1.75;
            }
        }
        double bankCharge() {
            double result = 4;
            if (_daysOverdrawn > 0)
                result += _daysOverdrawn * 1.75;
            return result;
        }
        private AccountType _type;
        private int _daysOverdrawn;
    }
    class AccountType {
        double overdraftCharge(int daysOverdrawn) {
            if (isPremium()) {
                double result = 10;
                if (daysOverdrawn > 7)
                    result += (daysOverdrawn - 7) * 1.5;
                return result;
            } else {
                return daysOverdrawn * 1.75;
            }
        }
    }
}
