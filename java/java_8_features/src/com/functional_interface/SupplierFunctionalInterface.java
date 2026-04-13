package com.functional_interface;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierFunctionalInterface {
	public static void main(String[] args) {
		Supplier<Integer> randomNumber = ()->new Random().nextInt(100);
		System.out.println(randomNumber.get());
	}
}
