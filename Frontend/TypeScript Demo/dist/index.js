"use strict";
// simple hello world program using typescript
Object.defineProperty(exports, "__esModule", { value: true });
console.log('hello world!');
//type checking
let counter;
//console.log(counter); // undefined
counter = 10; // valid assignment
//counter = 'hello'; // invalid assignment, will cause a type error
var counterVar;
counterVar = 10; // valid assignment
counterVar = 'hello'; // valid assignment, no type checking for var
console.log(counterVar); // hello
var counterVar2 = 10;
//counterVar2 = 'hello'; // valid assignment, no type checking for var
let counterVar3 = counterVar;
counterVar3 = "10"; // valid assignment
counterVar3 = 'hello'; // invalid assignment, will cause a type error
var counterVar4 = 1_000;
console.log(counterVar4); // 1000
let descriptio = `This 
is 
a multi-line string
Demo`;
console.log(descriptio); // This is a multi-line string Demo
let myName = "Dushyant";
let greeting = 'Welcome';
console.log(`${greeting} ${myName}`); // Welcome Dushyant
//before this in config file add in style ptions : 
function checkDoc(doc) {
    console.log(doc);
}
checkDoc({ name: "Dushyant", age: 25 }); // { name: 'Dushyant', age: 25 }
checkDoc("Hello World"); // Hello World
checkDoc(10); // 10
checkDoc(true); // true
checkDoc([1, 2, 3]); // [ 1, 2, 3 ]
//array type checking
// let myArray: number[] = [1, 2, 3, 4, 5];
// console.log(myArray); // [ 1, 2, 3, 4, 5 ]
// let arrayAny = [];
// arrayAny[0] = 1;
// arrayAny[1] = 'hello';
// arrayAny[2] = true;
// console.log(arrayAny); // [ 1, 'hello', true ]
// sum of array numbers and even odd
let numbers = [1, 2, 3, 4, 2];
console.log("Numbers =", numbers);
let sum = 0;
let odd = 0;
let even = 0;
for (let num of numbers) {
    sum = sum + num;
    if (num % 2 == 0) {
        even++;
        console.log(num + " is even");
    }
    else {
        odd++;
        console.log(num + " is odd");
    }
}
console.log("Sum =", sum);
console.log("Even numbers =", even);
console.log("Odd numbers =", odd);
//convert string array to uppercase
let names = ["john", "rahul", "amit", "dushyant"];
for (let name of names) {
    console.log(name.toUpperCase());
}
// Additional functions added as requested
function calculateTax(income) {
    let tax = 0.1;
    if (income < 30000) {
        return "Hello, Your Tax is : " + (income * tax);
    }
    return "Hello, Your Tax is : " + (income * 0.2);
}
console.log(`Tax is ${calculateTax(10000)}`); // No error, return type is inferred as string
function getDouble(num) {
    return num * 2;
}
console.log(`Double is ${getDouble(10)}`); // No error, return type is inferred as number
//# sourceMappingURL=index.js.map