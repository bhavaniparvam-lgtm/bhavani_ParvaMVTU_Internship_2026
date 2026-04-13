package assignment_6;


import java.util.function.Consumer;
import java.util.ArrayList;

public class Consumer1 {
    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();
        students.add("Kalyani");
        students.add("Rahul");
        students.add("Anita");

        // Correct: using Consumer interface
        Consumer<String> printName = name -> {
            System.out.println("Student: " + name);
        };

        students.forEach(printName);
    }
}
