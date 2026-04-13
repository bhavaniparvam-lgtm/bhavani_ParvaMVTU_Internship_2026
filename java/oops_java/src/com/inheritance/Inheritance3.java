package com.inheritance;

class Vehicle{
	public String brand;
	public String model;
	
	public Vehicle(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}
	//right click --> generate constructor using field --> select the variable
	
//	Vehicle(String brand, String model){
//		this.brand=brand;
//		this.model=model;
//	}
	
}

class Car extends Vehicle{
	public int noWheels;

	public Car(String brand, String model, int noWheels) {
		super(brand, model);
		//super is a reference to the immediate parent class object.
		//this is a reference to the current object of the class.
		this.noWheels = noWheels;
		
	}

	@Override //right click --> generate toString
	public String toString() {
		return "Car [noWheels=" + noWheels + ", brand=" + brand + ", model=" + model + "]";
	}
	
	
	
}
public class Inheritance3 {
	public static void main(String[] args) {
		Car c = new Car("Defender","Model-X",4);
		System.out.println(c);//package name. class name. @husky code (address)
		
	}
}
