package array_java;

import java.util.Arrays;

public class Arrays1 {
	public static void main(String[] args) {
		/*
		 * Arrays:
		 * =======
		 * it is a collection of similar data elements(all integers, all strings)
		 * data_tytpe arr_name[] = {values};
		 * data_type arr_name[] = new data_type[size];
		 * int arr[] = new int[4];
		 * 
		 * types:
		 * ======
		 * 1D
		 * 2D
		 * multi D*/
		
		//String array
		String names[] = new String[5];//0---->4
		names[0]="Cal";
		names[1]="Lana";
		names[2]="Callahan";
		names[3]="Alana";
		names[4]="Cami";
		
		System.out.println("Array:"+Arrays.toString(names));
				
				
	}
}
