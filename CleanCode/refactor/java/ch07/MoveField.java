package refactor.java.ch07;

public class MoveField {
    class Account {
        private AccountType _type;
        private double _interestRate;

        double interestForAmount_days(double amount, int days) {
            // return _interestRate * amount * days / 365;
            return getInterestRate() * amount * days / 365;
        }

        void setInterestRate(double interestRate) {
            _interestRate = interestRate;
        }

        double getInterestRate() {
            return _interestRate;
        }

        double interestForAmountAndDays(double amount, int days) {
            return getInterestRate() * amount * days / 365;
        }

        private void setInterestRate(double arg) {
            _type.setInterestRate(arg);
        }

        private double getInterestRate() {
            return _type.getInterestRate();
        }
    }
}
