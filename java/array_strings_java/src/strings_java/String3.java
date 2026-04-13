package strings_java;

public class String3 {
	public static void main(String[] args) {
		/*
		 * String in java are immutable
		 * once we create a string we will not be able to change the value of it
		 * to overcome this problem
		 * 1. string buffer
		 * 2. string builder*/
		String str1 = "Callahan";
		System.out.println("Before: "+str1);
		str1 = str1.concat(" Kane");
		System.out.println("After: "+str1);
	}
}
