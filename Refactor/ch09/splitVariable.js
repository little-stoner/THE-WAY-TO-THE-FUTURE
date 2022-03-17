function distanceTravelled(scenario, time) {
    let result;
    let acc = scenario.primaryForce / scenario.mass; 
    let primaryTime = Math.min(time, scenario.delay); 
    result = 0.5 * acc * primaryTime * primaryTime; 
    let secondaryTime = time - scenario.delay;
    if (secondaryTime > 0) {
        let primaryVelocity = acc * scenario.delay;
        acc = (scenario.primaryForce + scenario.secondaryForce) / scenario.mass;
        result += primaryVelocity * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
    }
    return result;
}


function distanceTravelled(scenario, time) {
    let result;
    const primaryAcceleration = scenario.primaryForce / scenario.mass; 
    let primaryTime = Math.min(time, scenario.delay); 
    result = 0.5 * primaryAcceleration * primaryTime * primaryTime; 
    let secondaryTime = time - scenario.delay;
    if (secondaryTime > 0) {
        let primaryVelocity = primaryAcceleration * scenario.delay;
        // let acc = (scenario.primaryForce + scenario.secondaryForce) / scenario.mass;
        let secondaryAcceleration = (scenario.primaryForce + scenario.secondaryForce) / scenario.mass;
        // result += primaryVelocity * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        result += primaryVelocity * secondaryTime + 0.5 * secondaryAcceleration * secondaryTime * secondaryTime;
    }
    return result;
}


function discount (inputValue, quantity) {
    if (inputValue > 50) 
        inputValue = inputValue - 2; 
    if (quantity > 100) 
        inputValue = inputValue - 1; 
    return inputValue;
}

function discount(originalInputValue, quantity) {
    let inputValue = originalInputValue;
    if (inputValue > 50) 
        inputValue = inputValue - 2; 
    if (quantity > 100) 
        inputValue = inputValue - 1; 
    return inputValue;
}

function discount(inputValue, quantity) {
    let result = inputValue;
    if (inputValue > 50) 
        inputValue = result - 2; 
    if (quantity > 100) 
        inputValue = result - 1; 
    return result;
}