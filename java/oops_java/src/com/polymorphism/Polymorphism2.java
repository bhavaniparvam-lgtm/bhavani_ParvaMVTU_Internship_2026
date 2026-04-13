package com.polymorphism;


class Shape{
	public void area() {
		System.out.println("Calculating area ....");
	}
}

class Circle extends Shape{
	private int r;

	public Circle(int r) {
		super();
		this.r = r;
	}
	
	@Override
	public void area() {
		System.out.println("res: "+(3.14*this.r*r));
	}

//	@Override
//	public String toString() {
//		return "Circle [r=" + r + "]";
//	}

	
	
}

public class Polymorphism2 {
	public static void main(String[] args) {
		Circle s1 = new Circle(2);
		s1.area();
		
	}
}
