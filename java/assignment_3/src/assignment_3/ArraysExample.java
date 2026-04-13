package assignment_3;


import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        // 1. Create an array
        int[] numbers = {5, 2, 8, 1, 9};
        System.out.println("Original Array: " + Arrays.toString(numbers));

        // 2. Sort the array
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        // 3. Search for an element
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("Index of 8: " + index);

        // 4. Fill an array
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 7);
        System.out.println("Filled Array: " + Arrays.toString(filledArray));

        // 5. Compare arrays
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {3, 2, 1};
        System.out.println("arr1 equals arr2? " + Arrays.equals(arr1, arr2));
        System.out.println("arr1 equals arr3? " + Arrays.equals(arr1, arr3));

        // 6. Copy arrays
        int[] copyArray = Arrays.copyOf(arr1, 5);
        System.out.println("Copied Array: " + Arrays.toString(copyArray));

        int[] rangeCopy = Arrays.copyOfRange(arr1, 1, 3);
        System.out.println("Copied Range (index 1-2): " + Arrays.toString(rangeCopy));
    }
}

