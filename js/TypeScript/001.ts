// kick off
interface Pointlike {
    x: number;
    y: number;
}
interface Named {
    name: string;
}

function logPoint(point: Pointlike) {
    console.log(" x = " + point.x + ", y = " + point.y)
}

function logName(x: Named) {
    console.log(" Hello, " + x.name)
}

const obj = {
    x: 0,
    y: 0,
    name: 'Origin',
};

logPoint(obj);
logName(obj);
//

//
// Basic Types

//// Boolean
let isDone: boolean = false;
//// Number
let decimal: number = 6;
let hex: number = 0xf00d;
let binary: number = 0b1010;
let octal: number = 0o744;
// let big: bigint = 100;
//// String
let color: string = 'blue';
color = 'red';
////// template string
let fullName='stone';
let sentence: string = `Hello, my name is ${fullName}`;
//// Array
let list: number[] = [1, 2, 3]
let list0: Array<number> = [1, 2, 3]
//// Tuple
let x: [string, number];
x = ['hello', 10];
//// Enum
enum Color {
    Red = 1,
    Green,
    Blue,
}
let c: Color = Color.Green;

//// Unknown
let notSure: unknown = 4;
notSure = "maybe a string instead"
notSure = false;

//// Any
declare function getValue(keu: string): any;
const str: string = getValue("myString");
let looselyTyped: any = 4;
looselyTyped.ifItItExitsts();
looselyTyped.toFixed();

//// Void
function warnUser(): void {
    console.log("This is my warning message")
}
let unusable: void = undefined;
unusable = null;

//// Null and Undefined
let u: undefined = undefined;
let n: null = null;

//// Never
function error(message: string): never {
    throw new Error(message);
}
function fail() {
    return error("Something failed");
}
function infiniteLoop(): never {
    while (true) {}
}

//// Object
declare function create(o: object | null);
create({ prop: 0 });
create(null);
create(undefined); // undefined is a subtype of null

//// Type assertions
let someValue: unknown = "this is a string";n
//let strLength: number = (someValue as string).length;
let strLength: number = (<string>someValue).length;

////
function reverse(s: String): String {
    return s.split("").reverse().join("");
}
console.log(reverse("hello world"));

function reverse(s: string): string {
    return s.split("").reverse().join("");
}
console.log(reverse("hello world"));


// Interfaces "duck typing"
function printLabel(labeledObj: { label: string }) {
    console.log(labeledObj.label);
}
let myObj = { size: 10, label: "Size 10 Object" };
printLabel(myObj);

interface LabeledValue {
    label: string;
}
function printLabel0(labeledObj: LabeledValue) {
    console.log(labeledObj.label);
}
let myObj = { size: 10, label: "Size 10 Object" };
printLabel(myObj);
//// Optional Properties
interface SquareConfig {
    color?: string;
    width?: number;
}
function createSquare(config: SaureConfig): { color: string, area: number } {
    let newSquare = { color: "white", area: 100 };
    if (config.color) {
        newSquare.color = config.color;
    }
    if (config.width) {
        newSquare.area = config.width * config.width;
    }
    return newSquare;
}

//// Readonly properties
interface Point {
    readonly x: number;
    readonly y: number;
}

//// Function Types
interface SearchFunc {
    (source: string, subString: string): boolean;
}
let mySearch: SearchFunc;
mySearch = function (source: string, subString: string) {
    let result = source.search(subString);
    return result > -1;
}

//// Indexable Types
interface StringArray {
    [index: number]: string;
}
let myArray: StringArray;
myArray = ["Bob", "Fred"];
let myStr: string = myArray[0];


//// Class Types
interface ClockInterface {
    currentTime: Date;
}
class Clock implements ClockInterface {
    currentTime: Date = new Date();
    constructor(h: number, m: number) {}
}
//// Extending Interfaces
interface Shape {
    color: string
}
interface Square extends Shape {
    sideLength: number;
}
//// Hybird Types
interface Counter {
    (start: number): string;
    interval: number;
    reset(): void;
}
//// Interfaces Extending Classes
class Control {
    private state: any;
}
interface SelectableControl extends Control {
    select(): void;
}

