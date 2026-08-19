"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Employee {
    id;
    emp_name;
    age;
    constructor(id, emp_name, age) {
        this.id = id;
        this.emp_name = emp_name;
        if (age !== undefined) {
            this.age = age;
        }
    }
}
let employee1 = new Employee(101, "Dushyant");
console.log("ID:", employee1.id);
console.log("Name:", employee1.emp_name);
console.log("Age:", employee1.age);
//usage of retire 
let product = {
    id: 1,
    name: "Laptop",
    price: 1000
};
product.name = "Desktop";
//# sourceMappingURL=optionalClassProperties.js.map