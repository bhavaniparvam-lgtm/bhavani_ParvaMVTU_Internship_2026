package assignment_1;
import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 5};
        int max = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Largest number: " + max);
    }
}

