
function foo() {};
foo.prototype = {
    foo_prop: "foo val"
};
function bar() {};
var proto = new foo;
proto.bar_prop = "bar val";
bar.prototype = new bar;
console.log(inst.foo_prop);
console.log(inst.bar_prop);


//////////////////////////

function foo(){}
foo.prototype = {
  foo_prop: "foo val"
};
function bar(){}
var proto = Object.create(
  foo.prototype
);
proto.bar_prop = "bar val";
bar.prototype = proto;
var inst = new bar;
console.log(inst.foo_prop);
console.log(inst.bar_prop);

function foo(){}
foo.prototype = {
  foo_prop: "foo val"
};
function bar(){}
var proto = Object.create(
  foo.prototype,
  {
    bar_prop: {
      value: "bar val"
    }
  }
);
bar.prototype = proto;
var inst = new bar;
console.log(inst.foo_prop);
console.log(inst.bar_prop)

/////////////////////////

function foo(){}
foo.prototype = {
  foo_prop: "foo val"
};
function bar(){}
var proto = {
  bar_prop: "bar val"
};
Object.setPrototypeOf(
  proto, foo.prototype
);
bar.prototype = proto;
var inst = new bar;
console.log(inst.foo_prop);
console.log(inst.bar_prop);

function foo(){}
foo.prototype = {
  foo_prop: "foo val"
};
function bar(){}
var proto;
proto=Object.setPrototypeOf(
  { bar_prop: "bar val" },
  foo.prototype
);
bar.prototype = proto;
var inst = new bar;
console.log(inst.foo_prop);
console.log(inst.bar_prop)

////////////////////////////

function foo(){}
foo.prototype = {
  foo_prop: "foo val"
};
function bar(){}
var proto = {
  bar_prop: "bar val",
  __proto__: foo.prototype
};
bar.prototype = proto;
var inst = new bar;
console.log(inst.foo_prop);
console.log(inst.bar_prop);

var inst = {
  __proto__: {
    bar_prop: "bar val",
    __proto__: {
      foo_prop: "foo val",
      __proto__: Object.prototype
    }
  }
};
console.log(inst.foo_prop);
console.log(inst.bar_prop)

