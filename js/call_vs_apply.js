
function theFunction(name, profession) {
    console.log("My name is " + name + " and I am a " + profession + ".");
    console.log(this.first)
}

var o = {
    first: 'k',
    second: 'p',
    hello: function() {
        return this.first + " " + this.second;
    }
}

theFunction("John", "fireman");
theFunction.apply(undefined, ["Su", "teacher"])
console.log('================================')

theFunction.apply(o)

