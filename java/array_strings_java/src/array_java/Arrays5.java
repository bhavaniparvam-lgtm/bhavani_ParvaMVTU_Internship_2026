package array_java;

import java.util.Arrays;

public class Arrays5 {
	public static void main(String[] args) {
		/*
		 * in java can we store multiple data type values in an array or not?
		 * --> it is possible using Object class.*/
		Object arr[] = new Object[4];
		
		arr[0]=12;
		arr[1]="Callahan";
		arr[2]="Kane";
		arr[3]=6.2;
		System.out.println("Array: "+Arrays.toString(arr));

	}
}
