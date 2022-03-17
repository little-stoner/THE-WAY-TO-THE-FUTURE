if (aCustomer === "unknown") customerName = "occupant";

class UnknownCustomer {
    get name() {return "occupant";}
}

// 
class Site {
    get customer() {
        return this._customer;
    }
}

class Customer {
    get name() {}
    get billingPlan() {}
    set billingPlan(arg) {}
    get paymentHistory() {}
}
class UnknownCustomer {
    get isUnknown() {
        return true;
    }
    get name() {
        return "occupant";
    }
    get billingPlan() {
        return CustomElementRegistry.billingPlans.basic;
    }
    get paymentHistory() {
        return new NullPaymentHistory();
    }
}
class NullPaymentHistory {
    get weeksDelinquentInLastYear() { return 0; }
}

function isUnknown(arg) {
    if (!((arg instanceof Customer) || (arg === "unknown")))
        throw new Error(`investigate bad value: <${arg}>`); 
    return (arg === "unknown");
}

class Site {
    get customer() {
        return (this._customer === "unknown") ? new UnknownCustomer() : this._customer;
    }
}
function isUnknown(arg) {
    if (!(arg instanceof Customer || arg instanceof UnknownCustomer)) {
        throw new Error(`investigate bad value: <${arg}>`);
    }
    return arg.isUnknown;
}