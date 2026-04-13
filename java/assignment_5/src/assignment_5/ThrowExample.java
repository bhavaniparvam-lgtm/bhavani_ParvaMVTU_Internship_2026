package assignment_5;
class AgeValidator {
    // Method that uses throw
    public static void checkAge(int age) {
        if (age < 18) {
            // throw = MANUALLY create and throw exception
            throw new IllegalArgumentException(
                "Access denied! You must be at least 18. Age given: " + age
            );
        }
        System.out.println("✅ Access granted! Welcome!");
    }
}

public class ThrowExample {
    public static void main(String[] args) {
        System.out.println("=== Testing throw keyword ===");
        
        try {
            AgeValidator.checkAge(15);  // Will throw!
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Caught: " + e.getMessage());
        }
        
        try {
            AgeValidator.checkAge(20);  // Will work!
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Caught: " + e.getMessage());
        }
        
        System.out.println("Program continues running...");
    }
}
