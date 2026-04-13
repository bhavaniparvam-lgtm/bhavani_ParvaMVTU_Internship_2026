package com.setInterface;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
public class SetInterface1 {
	public static void main(String[] args) {
		Set<Integer> s1 = new HashSet<Integer>();
		s1.add(12);
		s1.add(14);
		s1.add(12);
		s1.add(14);
		s1.add(null);
		s1.add(100);
		s1.add(null);
		System.out.println(s1);
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(100);
		marks.add(120);
		marks.add(130);
		marks.add(130);
		marks.add(140);
		marks.add(150);
		marks.add(100);
		marks.add(140);
		System.out.println(marks);
		Set<Integer> s2 = new HashSet<Integer>(marks);
		System.out.println(s2);
	}
}
