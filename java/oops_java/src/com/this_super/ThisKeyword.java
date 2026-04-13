package com.this_super;


class Student{
	String name;
	int roll;
	static String college = "CEC";
	public Student() {
		this("Callahan Kane", 24);
	}
	
	public Student(String name, int roll) {
		super();
		this.name = name;
		this.roll = roll;
		System.out.println("values from constructor: "+this.name+" "+this.roll+" "+this.college);
	}
	
	
}
public class ThisKeyword {
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println("Name: "+s1.name);
		System.out.println("roll: "+s1.roll);
		
	}
}
