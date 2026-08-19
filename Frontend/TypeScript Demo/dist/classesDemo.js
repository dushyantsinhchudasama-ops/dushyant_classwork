"use strict";
//how to create and use classes and objects in typescript
Object.defineProperty(exports, "__esModule", { value: true });
let calculator1 = {
    value: 10,
    double: (num) => num * 2
};
console.log(calculator1.value);
console.log(calculator1.double(20));
//using union types in classes and objects
function kgtoLbs(weight) {
    if (typeof weight === "number") {
        return weight * 2.2;
    }
    else {
        let parsedWeight = parseFloat(weight);
        if (!isNaN(parsedWeight)) {
            return parsedWeight * 2.2;
        }
        else {
            throw new Error("Invalid weight format");
        }
    }
}
console.log(kgtoLbs("100"));
// console.log(kgtoLbs("Dushyant"));
//working with default values in calsses
class PointOverload {
    x;
    y;
    s = 's';
    constructor(x, y, s) {
        this.x = x;
        this.y = y;
        if (s) {
            this.s = s;
        }
    }
}
let p1 = new PointOverload(10, 20);
console.log(p1.x);
console.log(p1.y);
console.log(p1.s);
let p2 = new PointOverload(30, 40, "Hello");
console.log(p2.x);
console.log(p2.y);
console.log(p2.s);
class Ring {
    ping() {
        console.log("ping");
    }
}
// console.log(Ring.prototype.ping());
// inheritance example
class Animal {
    move() {
        console.log("Animal is moving");
    }
}
class Dog extends Animal {
    woofs(times) {
        for (let i = 0; i < times; i++) {
            console.log("Woof!");
        }
    }
}
const d = new Dog();
d.move();
d.woofs(3);
//# sourceMappingURL=classesDemo.js.map