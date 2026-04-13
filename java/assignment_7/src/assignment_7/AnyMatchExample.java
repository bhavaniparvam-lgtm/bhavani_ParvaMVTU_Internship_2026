package assignment_7;
import java.util.*;

public class AnyMatchExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 150, 40);

        boolean result = list.stream()
                             .anyMatch(n -> n > 100);

        System.out.println(result);
    }
}
