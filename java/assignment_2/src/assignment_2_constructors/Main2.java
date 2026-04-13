package assignment_2_constructors;
class Person {
    String name;
    int age;
    String email;

    // 1. No‑arg constructor with default values
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.email = "unknown@example.com";
    }

    // 2. 2‑parameter constructor (name and age)
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = "not provided";
    }

    // 3. 3‑parameter constructor (name, age, and email)
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // 4. display() method to print all three variables
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println(); // empty line for readability
    }
}

public class Main2 {
    public static void main(String[] args) {
        // 5. Create one object using each constructor and call display()

        Person p1 = new Person();                          // no‑arg
        p1.display();

        Person p2 = new Person("Alice", 20);               // 2‑parameter
        p2.display();

        Person p3 = new Person("Bob", 25, "bob@email.com"); // 3‑parameter
        p3.display();
    }
}

