package assignment_6;

import java.util.function.Supplier;

public class Supplier1 {
    public static void main(String[] args) {

        Supplier<String> msg = () -> {
            return "Hello Kalyani";
        };

        System.out.println(msg.get());
    }
}
