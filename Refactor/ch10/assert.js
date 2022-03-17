import { assert } from "chai";

function foo() {
    if (this.discountRate)
        base = base - (this.discountRate * base);
}

assert(this.discountRate >= 0);

class Customer {
    set discountRate(aNumber) {
        assert(null === aNumber || aNumber >= 0);
        this._discountRate = aNumber;
    }
}