const { assert } = require("chai");

class Customer {
    constructor(name, discountRate) {
        this._name = name;
        this._discountRate = discountRate;
        this._contract = new CustomerContract(dateToday());
    }
    get plan() { return this._plan; }
    get discountRate() { return this._discountRate; }
    becomePreferred() {
        this._discountRate += 0.03;
    }
    applyDiscount(amount) {
        return amount.subtract(amount.multiply(this._discountRate));
    }
}
class CustomerContract {
    constructor(startDate, discountRate) {
        this._startDate = startDate;
        this._discountRate = discountRate;
    }
    get discountRate() { return this._discountRate; }
    set discountRate(arg) { this._discountRate = arg; }
}

class Customer {
    get plan() { return this._plan; }
    get discountRate() { return this.plan.discountRate; }
}
///////////////////
class Account {
    constructor(number, type, interestRate) {
        this._number = number;
        this._type = type;
        assert(interestRate === this._type.interestRate);
        this._interestRate = interestRate;
    }
    get interestRate() { return this._interestRate; }
    get interestRate() { return this._type.interestRate; }
}
class Account {
    constructor(number, type) {
        this._number = number;
        this._type = type;
    }
    get interestRate() { return this._type.interestRate; }
}
class AccountType {
    constructor(nameString, interestRate) {
        this._name = nameString;
        this._interestRate = interestRate;
    }
    get interestRate() { return this._interestRate; }
}