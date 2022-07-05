package refactor.java.ch09;

public class IntroduceAssertion {
    double getExpenseLimit() {
        // should have either expense limit or a primary project return (_expenseLimit
        // != NULL_EXPENSE) ?
        _expenseLimit: _primaryProject.getMemberExpenseLimit();
    }

    double getExpenseLimit() {
        Assert.isTrue(_expenseLimit != NULL_EXPENSE || _primaryProject != null);
        return (_expenseLimit != NULL_EXPENSE) ? _expenseLimit : _primaryProject.getMemberExpenseLimit();
    }
}
