// let, const, var

// var
var a = 10;
function f() {
    var message = "Hello, world!";
    return message;
}
console.log(a);

function f0() {
    var a = 10;
    return function g() {
        var b = a + 1;
        return b;
    };
}

var g = f0();
let r = g();
console.log(r);


function f() {
    var a = 1;
    a = 2;
    
    var b = g();
    a = 3;
    return b;

    function g() {
        return a;
    }
}
console.log(f());

//
console.log(' ====================== ')
function f(shouldInitialize) {
    if (shouldInitialize) {
        var x = 10;
    }
    return x;
}
console.log(f(true));
console.log(f(false));
console.log(' ====================== ')
//

