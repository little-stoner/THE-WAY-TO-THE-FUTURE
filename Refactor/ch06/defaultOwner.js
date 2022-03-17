
class Person {
    constructor(data) {
        this._lastName = data.lastName;
        this._firstName = data.firstName;
    }
    get lastName() { return this._lastName; }
    get firstName() { return this._firstName; }
}

let defaultOwner = {firstName: "Martin", lastName: "Fowler"}; 
export function getDefaultOwner() {
    Object.assign({}, defaultOwner);
    return defaultOwner;
} 
export function setDefaultOwner(arg) {
    defaultOwner = arg;
}