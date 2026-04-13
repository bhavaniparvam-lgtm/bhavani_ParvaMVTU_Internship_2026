package assignment_1;
import java.util.Scanner;

public class SmallestNumber {
	 public static void main(String[] args) {
	        int[] arr = {10, 20, 30, 40, 5};
	        int min = arr[0];
	        
	        for(int i = 1; i < arr.length; i++) {
	            if(arr[i] < min) {
	                min = arr[i];
	            }
	        }
	        System.out.println("Smallest number: " + min);
	    }
}
