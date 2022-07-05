package refactor.java.ch06;

public class ReplaceMethodWithMethodObject {
    
    class Account {
        int gamma(int inputVal, int quantity, int yearToDate) {
            int importantValue1 = (inputVal * quantity) + delta();
            int importantValue2 = (inputVal * yearToDate) + 100;
            if ((yearToDate - importantValue1) > 100) {
                importantValue2 -= 20;
            }
            int importantValue3 = importantValue2 * 7;
            return importantValue3 - 2 * importantValue1;
        }
    }

    class Gamma {
        private int Account account;
        private int inputVal;
        private int quantity;
        private int yearToDate;
        private int importantValue1; 
        private int importantValue2;
        private int importantValue3; 
        public Gamma(int inputVal, int quantity, int yearToDate) {
            this.inputVal = inputVal;
            this.quantity = quantity;
            this.yearToDate = yearToDate;
        }
        int delta() {
            return account.delta();
        }
        int compute() {
            importantValue1 = (inputVal * quantity) + delta();
            importantValue2 = (inputVal * yearToDate) + 100;
            if ((yearToDate - importantValue1) > 100) {
                importantValue2 -= 20;
            }
            importantValue3 = importantValue2 * 7;
            return importantValue3 - 2 * importantValue1;
        }
        int gamma(int inputVal, int quantity, int yearToDate) {
            return new Gamma(inputVal, quantity, yearToDate).compute();
        }
    }

}
