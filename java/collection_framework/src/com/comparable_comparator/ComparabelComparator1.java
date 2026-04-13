package com.comparable_comparator;
import java.util.ArrayList;
import java.util.Collections;

public class ComparabelComparator1 {
	public static void main(String[] args) {
		//
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1000);
		arr.add(30);
		arr.add(2);
		arr.add(25);
		arr.add(5);
		Collections.sort(arr);
		System.out.println("using comparable: "+arr);
		Collections.sort(arr,(a1,a2)->a2-a1);
		System.out.println("using comparator: "+arr);
	}
}
