package assignment_1;

public class ReverseArray {
	 public static void main(String[] args) {
	        int[] arr = {10, 20, 30, 40, 5};
	        
	        System.out.print("Reversed array: ");
	        for(int i = arr.length - 1; i >= 0; i--) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
}
