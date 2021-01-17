
const wait = time => new Promise(
    res => setTimeout(() => res(), time)
)

wait(200)
    // onFultilled() can return a new promise, `x`
    .then(() => new Promise(res => res('foo')))
    // the next promise will assume the state of `x`
    .then(a => a)
    // Above we returned the unwrapped value of `x`
    // so `.then()` above returns a fulfilled promise 
    // with that value
    .then(b => console.log(b)) // 'foo'
    // `null` is a valid promise value
    .then(() => null)
    .then(c => console.log(c)) // null
    .then(() => { throw new Error('foo'); })
    .then(
        // Nothing is logged here due to error above:
        d => console.log(`d: ${ d }`),
        // Now we handle the erro (rejection reason)
        e => console.log(e)) // [Error: foo]
    // with the previous exception handled, we can continue:
    .then(f => console.log(`f: ${ f }`)) // f: undefined
    // the following doesn't log. e was already handled,
    // so this handle doesn't get called
    .catch(e => console.log(e))
    .then(() => { throw new Error('bar'); })
    // when a promise is rejected, success handlers get skipped.
    // Nothing logs here because of the 'bar' exception:
    .then(g => console.log(`g: ${ g }`))
    .catch(h => console.log(h)) // [Error: bar]

    
