/**
 * Don;t know why it's reporting errors in some IDEs, please copy paste the code to other places to run
 */

/**
 * Closure: It solves the counter dilemma.
 * The counter is a local var instead of global var but still be able to keep the states during multiple calls.
 */

//Use global var, no closure..............................
// Initiate counter
var counter = 0;

// Function to increment counter
function add() {
    counter += 1;
}

// Call add() 3 times
add();
add();
add();
// The counter should now be 3


//use Closure, the counter is local now............................
var add = (function () {
    var counter = 0;
    return function () {
        counter += 1;
        return counter
    }
})();

add();
add();
add();
// the counter is now 3


/**
 * Promise: used for asynchronous callbacks...................
 * */

var promise = new Promise(function (resolve, reject) {
    //setTimeout(resolve('Call resolve after 100 milliseconds'), 100);
    //the reject will not execute if we do not comment out the previous line
    setTimeout(reject, 100, 'Call reject');
});

promise.then((msg) = > {
    console.log("I'm resolve, the following line is the message");
console.log(msg);
},
(msg) = >
{
    console.log("I'm reject, the following line is the message");
    console.log(msg);
});


/**
 Immutable is not just const
 freeze can only freeze the first level...
 **/

const a = Object.freeze({
    foo: 'Hello',
    bar: 'world',
    baz: '!',
    mutable: {x:1}
});

a.foo = 'Goodbye';
// Error: Cannot assign to read only property 'foo' of object Object