function getTotalOutstandingAndSendBill() {
    const result = customer.invoices.reduce((total, each) => each.amount + total, 0); 
    sendBill();
    return result;
}
function totalOutstanding() {
    return customer.invoices.reduce((total, each) => each.amount + total, 0);
}
function sendBill() {
    emailGateway.send(formatBill(customer)); 
}

///////////
function alertForMiscreant(people) {
    for (const p of people) {
        if (p === "Don") {
            setOffAlarms();
            return "Don";
        }
        if (p === "John") {
            setOffAlarms();
            return "John";
        }
    }
    return "";
}


function findMiscreant(people) {
    for (const p of people) {
        if (p === "Don") {
            setOffAlarms();
            return "Don";
        }
        if (p === "John") {
            setOffAlarms();
            return "John";
        }
    }
    return "";
}

function alertForMiscreant (people) {
    if (findMiscreant(people) !== "") setOffAlarms();
}