package all_operators;

public class OperatorsDemo {

	public static void main(String[] args) {
		int a = 10, b = 5;

		// Arithmetic
		System.out.println("a + b = " + (a + b));

		// Relational
		System.out.println("a > b: " + (a > b));

		// Logical
		boolean x = true, y = false;
		System.out.println("x && y: " + (x && y));

		// Assignment
		a += 3;
		System.out.println("a after += 3: " + a);

		// Unary
		System.out.println("++b: " + (++b));

		// Bitwise
		System.out.println("a & b: " + (a & b));

		// Ternary
		int max = (a > b) ? a : b;
		System.out.println("Max: " + max);
	}
}
