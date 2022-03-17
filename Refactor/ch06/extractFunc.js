function printOwing(invoice) {
    printBanner();
    let outstanding = calculateOutstanding();
    //
    console.log(`name: ${invoice.customer}`);
    console.log(`amount: ${outstanding}`);
}

function printOwing(invoice) {
    printBanner();
    let outstanding = calculateOutstanding();
    printDetails();
    function printDetails() {
        console.log(`name: ${invoice.customer}`);
        console.log(`amount: ${outstanding}`);
    }
}

function printOwing(invoice) {
    let outstanding = 0;
    console.log("***********************"); 
    console.log("**** Customer Owes ****"); 
    console.log("***********************");
    // calculate outstanding
    for (const o of invoice.orders) {
        outstanding += o.amount;
    }
    // record due date
    const today = Clock.today;
    invoice.dueDate = new Date(today.getFullYear(), today.getMonth(), today.getDate() + 30);
    //print details
    printDetails();
    function printDetails() {
        console.log(`name: ${invoice.customer}`); 
        console.log(`amount: ${outstanding}`);
        console.log(`due: ${invoice.dueDate.toLocaleDateString()}`);
    }
}

function printBanner() {
    console.log("***********************"); 
    console.log("**** Customer Owes ****"); 
    console.log("***********************");
}

function recordDueDate(invoice) {
    const today = Clock.today;
    invoice.dueDate = new Date(today.getFullYear(), today.getMonth(), today.getDate() + 30); 
}

function printDetails(invoice, outstanding) {
    console.log(`name: ${invoice.customer}`); 
    console.log(`amount: ${outstanding}`);
    console.log(`due: ${invoice.dueDate.toLocaleDateString()}`);
}