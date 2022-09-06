function run(generatorFunction) {
    const iterator = generatorFunction();
    (function handleNext(value) {
        const next = iterator.next(value);
        if (next.done) {
            return next.value;
        } else {
            return Promise.resolve(next.value).then(
                handleNext,
                err => Promise.resolve(iterator.throw(err)).then(hanldeNext)
            )
        }
    })();
}

run(function *() {
    try {
        const usersResponse = yield fetch(`${apiUrl}/users`);
        console.log(usersResponse);
    } catch(err) {
        console.err(err)
    }
});
