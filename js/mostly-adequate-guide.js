class Flock {
    constructor(n) {
        this.seagulls = n;
    }
    conjoin(other) {
        this.seagulls += other.seagulls;
        return this;
    }
    breed(other) {
        this.seagulls = this.seagulls * other.seagulls;
        return this;
    }
}
const flockA = new Flock(4);
const flockB = new Flock(2);
const flockC = new Flock(0);
const result = flockA.conjoin(flockC).bread(flockB).conjoin(flockA.breed(flockB)).seagulls;

const conjoin = (flockX, flockY) => flockX + flockY;
const breed = (flockX, flockY) => flockX * flockY;
const flockA = 4;
const flockB = 2;
const flockC = 0;
const result = conjoin(breed(flockB, conjoin(flockA, flockC)), breed(flockA, flockB));


/////// First Class

ajaxCall(json => callback(json));
ajaxCall(callback);
// ignorant
const getServerStuff = callback => ajaxCall(json => callback(json));
// enlightened
const getServerStuff = ajaxCall;


const BlogController = {
  index(posts) { return Views.index(posts); },
  show(post) { return Views.show(post); },
  create(attrs) { return Db.create(attrs); },
  update(post, attrs) { return Db.update(post, attrs); },
  destroy(post) { return Db.destroy(post); },
};
const BlogController = {
  index: Views.index,
  show: Views.show,
  create: Db.create,
  update: Db.update,
  destroy: Db.destroy,
};

// Curring
const always = curry((a, b) => a);
const compose = (...fns) => (...args) => fns.reduceRight((res, fn) => [fn.call(null, ...res)], args)[0];
function curry(fn) {
    const arity = fn.length;
    return function $curry(...args) {
        if (args.length < arity) {
            return $curry.bind(null, ...args);
        }
        return fn.call(null, ...args);
    }
}

const add = x => y => x + y;
const increment = add(1);
const addTen = add(10);
increment(2);
addTen(2);

const match = curry((what, s) => s.match(what));
const replace = curry((what, replacement, s) => s.replace(what, replacement));
const filter = curry((f, xs) => xs.filter(f));
const map = curry((f, xs) => xs.map(f));

match(/r/g, 'hello world'); // [ 'r' ]

const hasLetterR = match(/r/g); // x => x.match(/r/g)
hasLetterR('hello world'); // [ 'r' ]
hasLetterR('just j and s and t etc'); // null

filter(hasLetterR, ['rock and roll', 'smooth jazz']); // ['rock and roll']

const removeStringsWithoutRs = filter(hasLetterR); // xs => xs.filter(x => x.match(/r/g))
removeStringsWithoutRs(['rock and roll', 'smooth jazz', 'drum circle']); // ['rock and roll', 'drum circle']

const noVowels = replace(/[aeiou]/ig); // (r,x) => x.replace(/[aeiou]/ig, r)
const censored = noVowels('*'); // x => x.replace(/[aeiou]/ig, '*')
censored('Chocolate Rain'); // 'Ch*c*l*t* R**n'


// Composing

