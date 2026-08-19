"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Student {
    name;
    age;
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    displayInfo() {
        console.log(`Name: ${this.name}, Age: ${this.age}`);
        console.log(`Name: ${this.name}, Age: ${this.age}`);
    }
}
let student1 = new Student("Dushyant", 25);
let student2 = new Student("John", 30);
console.log(student1.name);
console.log(student2.name);
student1.displayInfo();
student2.displayInfo();
//making a property optional in a class
//# sourceMappingURL=classesNobjects.js.map