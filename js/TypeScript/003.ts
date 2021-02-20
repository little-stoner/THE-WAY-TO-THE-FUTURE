
//// Generics

function identity(arg: number): number {
    return arg;
}

console.log(identity(1))
console.log(identity('1'))

function identity<T>(arg: T): T {
    return arg;
}

let output = identity<string>("myString");
let output = identity("myString");

function loggingIdentity<T>(arg: Array<T>): Array<T> {
    console.log(arg.length);
    return arg;
}

//////// Generic Types

let myIdentity: <T>(arg: T) => T = identity;
let myIdentity: { <T>(arg: T): T } = identity;

interface GenericIdentityFn {
    <T>(arg: T): T;
}
interface GenericIdentityFn<T> {
    (arg: T): T;
}
let myIdentity: GenericIdentityFn = identity;

/////// Generic Classes
class GenericNumber<T> {
    zeroValue: T;
    add: (x: T, y: T) => T;
}
//////// Generic Constraints
interface Lengthwise {
    length: number;
}
function loggingIdentity<T extends Lengthwise>(arg: T): T {
    console.log(arg.length);
    return arg;
}
function getProperty<T, K extends keyof T>(obj: T, ke: K) {
    return obj[key];
}
//////// Class Types
function create<T>(c: { new (): T}): T {
    return new c();
}
