package com.method_reference;

import java.util.Arrays;
import java.util.function.Supplier;

public class InstanceMethodReference2 {
	
	public static void main(String[] args) {
		String [] names = {"Declan", "Callahan", "Rowan", "Lennox", "Murthy"};
		//without
		Arrays.sort(names, (s1,s2)->s1.compareToIgnoreCase(s2));
		System.out.println(Arrays.toString(names));
		//with
		Arrays.sort(names, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(names));
		
	}
}
