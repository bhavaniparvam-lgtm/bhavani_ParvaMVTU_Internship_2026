package assignment_1;

public class CopyArray {
	public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40, 5};
        int[] arr2 = new int[arr1.length];
        
        for(int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        
        System.out.print("Copied array: ");
        for(int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
