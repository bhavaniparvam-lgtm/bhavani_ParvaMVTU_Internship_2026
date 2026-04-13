package assignment_7;
import java.util.*;

public class SecondMax {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 25, 5, 40, 40, 15);

        int secondMax = list.stream()
                            .distinct()
                            .sorted((a, b) -> b - a)
                            .skip(1)
                            .findFirst()
                            .get();

        System.out.println("Second Max: " + secondMax);
    }
}
