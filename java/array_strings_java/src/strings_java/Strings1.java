package strings_java;

public class Strings1 {
	public static void main(String[] args) {
		/*
		 * String:
		 * =======
		 * in java string is an object 
		 * it is a collection of characters
		 * enclosed within ""
		 * syntax:
		 * =======
		 * 1.string literal : it will store in string constant pool(scp)
		 *  String str_name = "value";
		 * 2.using new keyword : it will store in heap memory
		 *  String str_name = new String("value");
		 *  */
		String str1 = "Cal";
		String str2 = new String("Cal");
		System.out.println(str1);
		System.err.println(str2);
	}
}
