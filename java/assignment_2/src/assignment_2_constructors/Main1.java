package assignment_2_constructors;
class Employee {
    String name;
    double salary;

    // 1. Parameterized constructor accepting name and salary
    public Employee(String name, double salary) {
        // 2. Use 'this' keyword to assign values
        this.name = name;
        this.salary = salary;
    }
}

public class Main1 {
    public static void main(String[] args) {
        // 3. Create an Employee object and pass values in constructor
        Employee employee = new Employee("Bob", 50000.0);

        // 4. Print the employee's name and salary
        System.out.println("Name: " + employee.name);
        System.out.println("Salary: " + employee.salary);
    }
}

