package assignment_2_constructors;
class Student {
    String name;
    int age;

    // 1. No-argument constructor that prints "Student Created"
    public Student() {
        System.out.println("Student Created");
    }
}

public class Main {
    public static void main(String[] args) {
        // 2. Create an object of the Student class
        Student student = new Student();

        // 3. Assign values to name and age using dot notation
        student.name = "Alice";
        student.age = 20;

        // 4. Print the student's name and age
        System.out.println("Name: " + student.name);
        System.out.println("Age: " + student.age);
    }
}
