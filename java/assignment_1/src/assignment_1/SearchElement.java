package assignment_1;
import java.util.*;
public class SearchElement {
	 public static void main(String[] args) {
	        int[] arr = {10, 20, 30, 40, 5};
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter element to search: ");
	        int key = sc.nextInt();
	        boolean found = false;
	        
	        for(int i = 0; i < arr.length; i++) {
	            if(arr[i] == key) {
	                System.out.println("Found at index: " + i);
	                found = true;
	                break;
	            }
	        }
	        if(!found) {
	            System.out.println("Not Found");
	        }
	        sc.close();
	    }
}
