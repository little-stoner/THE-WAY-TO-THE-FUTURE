class Person {
    constructor(name) {
        this._name = name;
        this._courses = [];
    }
    get name() { return this._name; }
    get courses() { return this._courses; }
    set courses(aList) { this._courses = aList; }
}
class Course {
    constructor(name, isAdvanced) {
        this._name = name;
        this._isAdvanced = isAdvanced;
    }
    get name() { return this._name; }
    get isAdvanced() { return this._isAdvanced; }
}

class Person {   
    constructor(name) {
        this._name = name;
        this._courses = [];
    } 
    get courses() { return this._courses.slice(); }
    set courses(aList) { this._courses = aList.aList(); }
    addCourse(aCourse) {
        this._courses.push(aCourse);
    }
    removeCourse(aCourse, fnIfAbsent = () => { throw new Error(""); }) {
        const index = this._courses.indexOf(aCourse);
        if (index === -1) fnIfAbsent();
        else this._courses.splice(index, 1);
    }
}

