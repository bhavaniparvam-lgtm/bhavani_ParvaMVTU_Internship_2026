package typecasting_java;

public class Implicit {
	public static void main(String[] args) {
		/*
		 * type casting:
		 * =============
		 * converting one data type to another data type
		 * "1" --> 1
		 * 1. implicit : auto conversion by jvm
		 * byte-->short-->int-->long-->float-->double
		 * 2.explicit:manually need to convert
		 * double-->float-->long-->int-->short-->byte
		 * syntax: (datatype)
		 * */
		int marks = 3000;
		System.out.println("int:"+marks);
		long marks1=marks;
		System.out.println("long:"+marks1);
	}
}
