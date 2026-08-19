"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var StudentStatus;
(function (StudentStatus) {
    StudentStatus["PASS"] = "Pass";
    StudentStatus["FAIL"] = "Fail";
})(StudentStatus || (StudentStatus = {}));
class Student {
    id;
    name;
    age;
    marks;
    status;
    constructor(id, name, age, marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.status = StudentStatus.FAIL;
    }
    calculatePercentage() {
        let total = this.marks[0] + this.marks[1] + this.marks[2];
        let percentage = total / 3;
        return percentage;
    }
    updateStatus() {
        let percentage = this.calculatePercentage();
        if (percentage >= 40) {
            this.status = StudentStatus.PASS;
        }
        else {
            this.status = StudentStatus.FAIL;
        }
    }
    displayDetails() {
        this.updateStatus();
        console.log("---------------");
        console.log("ID:", this.id);
        console.log("Name:", this.name);
        console.log("Age:", this.age);
        console.log("Marks:", this.marks);
        console.log("Percentage:", this.calculatePercentage());
        console.log("Status:", this.status);
        console.log("---------------");
    }
}
// Array of Student objects
let students = [];
// Add Student
function addStudent(id, name, age, marks) {
    let student = new Student(id, name, age, marks);
    students.push(student);
    console.log("Student added successfully.");
}
// Display all students
function displayStudents() {
    if (students.length === 0) {
        console.log("No students available.");
        return;
    }
    for (let student of students) {
        student.displayDetails();
    }
}
// Calculate percentage of all students
function calculatePercentage() {
    if (students.length === 0) {
        console.log("No students available.");
        return;
    }
    for (let student of students) {
        console.log(student.name + " : " +
            student.calculatePercentage() + "%");
    }
}
// Find passed students
function findPassedStudents() {
    console.log("Passed Students:");
    for (let student of students) {
        student.updateStatus();
        if (student.status === StudentStatus.PASS) {
            console.log(student.name);
        }
    }
}
// Find failed students
function findFailedStudents() {
    console.log("Failed Students:");
    for (let student of students) {
        student.updateStatus();
        if (student.status === StudentStatus.FAIL) {
            console.log(student.name);
        }
    }
}
// Display details of one student
function displayStudentDetails(id) {
    for (let student of students) {
        if (student.id === id) {
            student.displayDetails();
            return;
        }
    }
    console.log("Student not found.");
}
// -------------------------------
// Testing the Student Management System
// -------------------------------
addStudent(1, "Dushyant", 25, [80, 75, 90]);
addStudent(2, "John", 22, [35, 40, 30]);
addStudent("S003", "Rahul", 23, [60, 70, 65]);
// Display all students
console.log("\n===== ALL STUDENTS =====");
displayStudents();
// Calculate percentages
console.log("\n===== PERCENTAGES =====");
calculatePercentage();
// Passed students
console.log("\n===== PASSED STUDENTS =====");
findPassedStudents();
// Failed students
console.log("\n===== FAILED STUDENTS =====");
findFailedStudents();
// Display one student's details
console.log("\n===== STUDENT DETAILS =====");
displayStudentDetails(1);
//# sourceMappingURL=student.js.map