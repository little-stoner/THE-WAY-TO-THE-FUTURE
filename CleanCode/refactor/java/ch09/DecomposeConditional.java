package refactor.java.ch09;

public class DecomposeConditional {
    class Ex {
        public void test(Date date) {
            if (date.before(SUMMER_START) || date.after(SUMMER_END))
                charge = quantity * _winterRate + _winterServiceCharge;
            else
                charge = quantity * _summerRate;
        }

        public void t(Date date) {
            if (notSummer(date))
                charge = winterCharge(quantity);
            else
                charge = summerCharge(quantity);
        }

        private boolean notSummer(Date date) {
            return date.before(SUMMER_START) || date.after(SUMMER_END);
        }

        private double summerCharge(int quantity) {
            return quantity * _summerRate;
        }

        private double winterCharge(int quantity) {
            return quantity * _winterRate + _winterServiceCharge;
        }
    }
}
