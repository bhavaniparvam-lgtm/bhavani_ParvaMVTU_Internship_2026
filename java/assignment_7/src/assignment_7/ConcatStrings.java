package assignment_7;
import java.util.*;

public class ConcatStrings {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "8", "Streams");

        String result = list.stream()
                            .reduce("", (a, b) -> a + b);

        System.out.println("Result: " + result);
    }
}
