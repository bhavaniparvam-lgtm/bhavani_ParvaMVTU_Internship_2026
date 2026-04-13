package array_java;

import java.util.Scanner;

public class Arrays3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an Array");
		int size = sc.nextInt();//5
		int arr[] = new int[size];//5-1=4
		int i=0;
		while(i<=size-1) {
			System.out.println("Enter "+ i +" element:");
			arr[i]=sc.nextInt();
			i++;
			
		}
		//print
		int sum=0;
		for(int j=0;j<=size-1;j++) {
			System.out.print(arr[j]+" ");
			sum +=arr[j];
		}
		System.out.println();
		System.out.println(sum);
		sc.close();
	}
}
