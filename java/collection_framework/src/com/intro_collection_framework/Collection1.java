package com.intro_collection_framework;

public class Collection1 {
	public static void main(String[] args) {
		
		int arr[]=new int[5];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		arr[4]=5;
		System.out.println("2nd index: "+arr[2]);//random access
		System.out.println(arr[0]);//no need to type cast
		
		//how to store multiple data type inside an array
		Object arr1[] = new Object[4];//there is no type safety
		arr1[0]="Callahan";
		arr1[1]=1.0;
		arr1[2]=123;
		arr1[3]=true;
		
		String name = (String)arr1[0];//need to type cast
		System.out.println("Name: "+name);
	}
}
