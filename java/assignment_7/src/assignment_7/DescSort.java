package assignment_7;
import java.util.*;

public class DescSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 9, 1, 7);

        list.stream()
            .sorted((a, b) -> b - a)   // descending
            .forEach(System.out::println);
    }
}
