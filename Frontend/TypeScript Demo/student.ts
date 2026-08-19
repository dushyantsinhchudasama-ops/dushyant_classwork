enum StudentStatus {
    PASS = "Pass",
    FAIL = "Fail"
}

class Student {

    readonly id: number | string;
    name: string;
    age: number;
    marks: [number, number, number];
    status: StudentStatus;

    constructor(
        id: number | string,
        name: string,
        age: number,
        marks: [number, number, number]
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;

        this.status = StudentStatus.FAIL;
    }

    calculatePercentage(): number {

        let total = this.marks[0] + this.marks[1] + this.marks[2];

        let percentage = total / 3;

        return percentage;
    }

    updateStatus(): void {

        let percentage = this.calculatePercentage();

        if (percentage >= 40) {
            this.status = StudentStatus.PASS;
        } else {
            this.status = StudentStatus.FAIL;
        }
    }

    displayDetails(): void {

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
let students: Student[] = [];


// Add Student
function addStudent(
    id: number | string,
    name: string,
    age: number,
    marks: [number, number, number]
): void {

    let student = new Student(id, name, age, marks);

    students.push(student);

    console.log("Student added successfully.");
}


// Display all students
function displayStudents(): void {

    if (students.length === 0) {
        console.log("No students available.");
        return;
    }

    for (let student of students) {
        student.displayDetails();
    }
}


// Calculate percentage of all students
function calculatePercentage(): void {

    if (students.length === 0) {
        console.log("No students available.");
        return;
    }

    for (let student of students) {

        console.log(
            student.name + " : " +
            student.calculatePercentage() + "%"
        );
    }
}


// Find passed students
function findPassedStudents(): void {

    console.log("Passed Students:");

    for (let student of students) {

        student.updateStatus();

        if (student.status === StudentStatus.PASS) {
            console.log(student.name);
        }
    }
}


// Find failed students
function findFailedStudents(): void {

    console.log("Failed Students:");

    for (let student of students) {

        student.updateStatus();

        if (student.status === StudentStatus.FAIL) {
            console.log(student.name);
        }
    }
}


// Display details of one student
function displayStudentDetails(id: number | string): void {

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