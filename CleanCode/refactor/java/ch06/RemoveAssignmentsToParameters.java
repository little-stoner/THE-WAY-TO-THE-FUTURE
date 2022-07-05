package refactor.java.ch06;

public class RemoveAssignmentsToParameters {

    int discount0(int inputVal, int quantity, int yearToDate) {
        if (inputVal > 50) inputVal -= 2;
        if (quantity > 100) inputVal -= 1;
        if (yearToDate > 10000) inputVal -= 4;
        return inputVal; 
    }
    
    int discount(int inputVal, int quantity, int yearToDate) {
        int result = inputVal;
        if (yearToDate > 100) {
            result -= 2;
        } else if (yearToDate > 10) {
            result -= 1;
        }
        if (quantity > 0 && quantity < 5) {
            result -= 1;
        }
        return result;
    }

}
