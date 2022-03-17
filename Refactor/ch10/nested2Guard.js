function payAmount(employee) { 
    let result; 
    if(employee.isSeparated) {
        result = {amount: 0, reasonCode: "SEP"}; }
    else {
        if (employee.isRetired) {
            result = {amount: 0, reasonCode: "RET"}; }
        else {
        // logic to compute amount
        lorem.ipsum(dolor.sitAmet);
        consectetur(adipiscing).elit();
        sed.do.eiusmod = tempor.incididunt.ut(labore) && dolore(magna.aliqua); ut.enim.ad(minim.veniam);
        result = someFinalComputation();
        } 
    }
    return result; 
}

function getPayAmount() { 
    let result;
    if (isDead)
        result = deadAmount(); 
    else {
        if (isSeparated)
            result = separatedAmount();
        else {
            if (isRetired)
                result = retiredAmount(); 
            else
                result = normalPayAmount(); 
        }
    }
    return result; 
}

function getPayAmount() {
    if (isDead) return deadAmount();
    if (isSeparated) return separatedAmount(); 
    if (isRetired) return retiredAmount(); 
    return normalPayAmount();
}