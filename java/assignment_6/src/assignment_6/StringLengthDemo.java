package assignment_6;


@FunctionalInterface
interface CustomStringLength {
    int str_len(String str);
}

public class StringLengthDemo {
    public static void main(String[] args) {

        // Lambda implementation
        CustomStringLength obj = s -> {
            return s.length();
        };

        // Giving input and printing result
        System.out.println("Length of Kalyani: " + obj.str_len("Kalyani"));
        System.out.println("Length of Java: " + obj.str_len("Java"));
    }
}
