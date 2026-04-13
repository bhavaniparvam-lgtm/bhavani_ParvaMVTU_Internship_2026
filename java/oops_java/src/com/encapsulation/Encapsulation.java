package com.encapsulation;


class Student{
	private String name;
	private int roll;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	
	
	//source --> generate getters and setters
	
//	public String getName() {
//		return this.name;
//	}
//	
//	public int getRoll() {
//		return this.roll;
//	}
//	
//	public void setName(String name) {
//		this.name=name;
//	}
//	
//	public void setRoll(int roll) {
//		this.roll=roll;
//	}

	
}
public class Encapsulation {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("Callahan Kane");
		System.out.println(s1.getName());
		s1.setRoll(1);
		System.out.println(s1.getRoll());
	}
}
