package assignment_6;

@FunctionalInterface
interface EvenOrOdd {
    boolean check(int num);
}

public class EvenOrOddDemo {
    public static void main(String[] args) {

        // Lambda implementation
        EvenOrOdd obj = n -> {
            return n % 2 == 0;
        };

        // Giving input and printing result
        System.out.println("Is 10 even? " + obj.check(10));
        System.out.println("Is 7 even? " + obj.check(7));
    }
}
