package com.method_reference;

import java.util.function.Consumer;

public class StaticMethodReference {
	public static void printMessage(String message){
		System.out.println("Your message is: "+message);
	}
	public static void main(String[] args) {
		//without static method reference
		Consumer<String> cons1 = s->StaticMethodReference.printMessage(s);
		cons1.accept("Callahan Kane");
		//with static method reference
		Consumer<String> cons2 = StaticMethodReference::printMessage;
		cons1.accept("Callahan Kane");
	}
}
