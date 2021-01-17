const wait = (
    time,
    cancel = Promise.reject()
) => new Promise((resolve, reject) => {

    const timer = setTimeout(resolve, time);
    const noop = () => { console.log('noop!!!!!!!!!!!!') };

    console.log('cancel: ', cancel)
    
    cancel.then(() => {
        console.log('#######################')
        clearTimeout(timer);
        reject(new Error('Cancel'));
    }, noop)
    
})

// const shouldCancel = Promise.resolve();
// wait(2000, shouldCancel).then(
//     () => console.log('HHHH'),
//     (e) => {
//         console.log(e)
//     }
// )

console.log("==============================================================")
wait(2000).then(
    () => console.log('QQ'),
    (e) => console.log(e)
)
