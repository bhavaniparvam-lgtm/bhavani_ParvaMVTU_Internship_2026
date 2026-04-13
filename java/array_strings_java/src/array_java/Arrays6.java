package array_java;

import java.util.Scanner;

public class Arrays6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an Array");
        int size = sc.nextInt();
        int arr[] = new int[size];
        int i = 0;
        while (i <= size - 1) {
            System.out.println("Enter " + i + " element:");
            arr[i] = sc.nextInt();
            i++;
        }
        // Print array
        for (int j = 0; j <= size - 1; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();  // New line after printing array
        
        // Find maximum element
        int max = arr[0];  // Initialize with first element
        for (int j = 1; j <= size - 1; j++) {  // Start from 1
            if (arr[j] > max) {
                max = arr[j];  // Fixed: use arr[j] instead of arr[i]
            }
        }
        System.out.println("Maximum element: " + max);  // Print the result
        
        // Find minimum element
        int min = arr[0];  // Initialize with first element
        for (int j = 1; j <= size - 1; j++) {
            if (arr[j] < min) {
                min = arr[j];
            }
        }
        System.out.println("Minimum element: " + min);
        sc.close();
    }
}
