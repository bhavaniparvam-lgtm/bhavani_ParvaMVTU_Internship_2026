package assignment_5;
import java.util.Scanner;
import java.util.InputMismatchException;

class UserInputProcessor {
    private Scanner scanner = new Scanner(System.in);
    
    public void processAge() throws IllegalArgumentException, InputMismatchException {
        System.out.print("Enter your age: ");
        
        // Safe Scanner input
        if (!scanner.hasNextInt()) {
            scanner.next(); // Clear invalid input
            throw new InputMismatchException("Please enter a number only!");
        }
        
        int age = scanner.nextInt();
        
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException(
                "Invalid age: " + age + ". Must be 0-150!"
            );
        }
        
        System.out.println("✅ Valid age: " + age);
    }
    
    public void processName() throws IllegalArgumentException {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();
        
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        
        System.out.println("✅ Welcome, " + name + "!");
    }
}

public class ThrowsExample {
    public static void main(String[] args) {
        UserInputProcessor processor = new UserInputProcessor();
        
        System.out.println("=== Scanner + throws Demo ===");
        
        try {
            processor.processAge();   // Test: 25, -5, abc
        } catch (InputMismatchException e) {
            System.out.println("❌ Input error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation error: " + e.getMessage());
        }
        
        try {
            processor.processName();  // Test: John, (empty)
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Name error: " + e.getMessage());
        }
        
        
        System.out.println("✅ Program finished!");
    }
}