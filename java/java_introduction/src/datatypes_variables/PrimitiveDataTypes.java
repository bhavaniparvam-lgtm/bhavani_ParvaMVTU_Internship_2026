package datatypes_variables;

public class PrimitiveDataTypes {
	public static void main(String[] args) {
		// byte
//		byte age;
//		age = 30;
		byte age = 30;// same line declaration and initialization
		System.out.println("Age is: " + age);

		short var1 = 20;
		System.out.println("s is:" + var1);

		int n = 50;
		System.out.println("n is:" + n);

		long l = 1000000;
		System.out.println("l is:" + l);

		long var2 = 10000000000000000l;// only if it's long
		System.out.println(var2);

		float v = 1.098709f;// mandatory f
		System.out.println(v);

		double d = -34.4324;// only if it's more then d
		System.out.println(d);

		char c = 'a';
		System.out.println(c);

		boolean b = true;
		System.out.println(b);

	}
}
