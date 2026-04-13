package com.super_final;


class Car{
	String name;
	static int noWheels = 4;
	
	public static void display() {
//		System.out.println("Name: "+this.name);
		System.out.println("No Wheels: "+Car.noWheels);
	}
}


public class StaticKeyword1 {
	public static void main(String[] args) {
		Car c = new Car();
		c.name="Defender";
//		c.display();
		Car.display();
		
		Car c1 = new Car();
		c1.name="Thar";
		Car.display();
	}
}
