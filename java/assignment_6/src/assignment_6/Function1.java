package assignment_6;

import java.util.function.Function;

public class Function1 {
    public static void main(String[] args) {

        // Function: String → Integer
        Function<String, Integer> findLength = name -> {
            return name.length();
        };

        // Giving input and storing output
        int result = findLength.apply("Kalyani");

        System.out.println("Length is: " + result);
    }
}
