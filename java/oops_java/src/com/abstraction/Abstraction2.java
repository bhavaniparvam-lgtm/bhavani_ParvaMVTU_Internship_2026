package com.abstraction;


interface Vehicle{
	int max=120;
	public abstract void start();//mentioning abstract is optional
	
}
class Car implements Vehicle{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Car is strated");
		
	}
	
}
public class Abstraction2 {
	public static void main(String[] args) {
		Car c = new Car();
		c.start();
	}
}
