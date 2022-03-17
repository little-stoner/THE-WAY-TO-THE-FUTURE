class Employee {}
class Salesman extends Employee { 
    get name() {}
}
class Engineer extends Employee {
    get name() {}
}

class Employee { 
    get name() {}
}
class Salesman extends Employee {} 
class Engineer extends Employee {}

//
class Employee {} // Java
class Salesman extends Employee { 
    // private String name;
}
class Engineer extends Employee { 
    // private String name;
}

class Employee { 
    // protected String name;
}
class Salesman extends Employee {} 
class Engineer extends Employee {}


//
class Party {}
class Employee extends Party {
     constructor(name, id, monthlyCost) {
        super();
        this._id = id;
        this._name = name; 
        this._monthlyCost = monthlyCost;
    }
}

class Party { 
    constructor(name) {
        this._name = name; 
    }
}
class Employee extends Party { 
    constructor(name, id, monthlyCost) {
        super(name);
        this._id = id;
        this._monthlyCost = monthlyCost;
    } 
}