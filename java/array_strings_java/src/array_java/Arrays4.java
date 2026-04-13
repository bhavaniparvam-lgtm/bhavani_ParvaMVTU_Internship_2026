package array_java;
import java.util.*;
public class Arrays4 {
	public static void main(String[] args) {
		/*
		 * 2D:
		 * ====
		 * [][] --> no_rows, no_columns
		 * int arr[][] =new int[2][3];//2*3 --> 6
		 * */
		Scanner sc= new Scanner(System.in);
		int arr[][] = new int[2][3];
		System.out.println("Enter Elements: ");
		for(int i=0;i<=1;i++) {//row
			for(int j=0;j<=2;j++) {//col
				System.out.println("Enter ["+i+"]  ["+j+"]  ele: ");
				arr[i][j]=sc.nextInt();
			}
		}
		//print
		for(int i=0;i<=1;i++) {
			for(int j=0;j<=2;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
			sc.close();
		}
	}
}
