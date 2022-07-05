package refactor.java.ch010;

public class EncapsulateDowncast {

    void withdraw(int amount) throws BalanceException {
        if (amount > _balance)
            throw new BalanceException();
        _balance -= amount;
    }

    int withdraw(int amount) {
        if (amount > _balance)
            return -1;
        else {
            _balance -= amount;
            return 0;
        }
    }
}
