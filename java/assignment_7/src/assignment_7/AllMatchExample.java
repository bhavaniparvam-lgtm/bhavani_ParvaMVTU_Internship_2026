package assignment_7;
import java.util.*;

public class AllMatchExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(120, 150, 200);

        boolean result = list.stream()
                             .allMatch(n -> n > 100);

        System.out.println(result);
    }
}
