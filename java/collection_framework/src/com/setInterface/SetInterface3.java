package com.setInterface;

import java.util.Set;
import java.util.TreeSet;
public class SetInterface3 {
	public static void main(String[] args) {
//		Set<Integer> s = new TreeSet<Integer>();
		Set<Integer> s = new TreeSet<Integer>((a,b)->b-a);
		s.add(20);
		s.add(30);
		s.add(20);
		s.add(5);
		s.add(2);
		s.add(10);
		s.add(200);
		System.out.println(s);
	}
}
