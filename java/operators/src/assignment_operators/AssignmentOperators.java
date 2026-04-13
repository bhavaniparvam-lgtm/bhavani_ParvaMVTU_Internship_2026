package assignment_operators;

public class AssignmentOperators {
	// Demonstration of all Assignment Operators in Java

	public static void main(String[] args) {
		int a = 10; // Simple assignment
		int b = 5;

		System.out.println("Initial values: a = " + a + ", b = " + b);

		// 1. Simple Assignment (=)
		a = b;
		System.out.println("After a = b: a = " + a + ", b = " + b);

		// Reset values
		a = 10;
		b = 5;

		// 2. Add and Assign (+=)
		a += b; // a = a + b
		System.out.println("After a += b: a = " + a);

		// 3. Subtract and Assign (-=)
		a -= b; // a = a - b
		System.out.println("After a -= b: a = " + a);

		// 4. Multiply and Assign (*=)
		a *= b; // a = a * b
		System.out.println("After a *= b: a = " + a);

		// 5. Divide and Assign (/=)
		try {
			a /= b; // a = a / b
			System.out.println("After a /= b: a = " + a);
		} catch (ArithmeticException e) {
			System.out.println("Division by zero error!");
		}

		// 6. Modulus and Assign (%=)
		a %= b; // a = a % b
		System.out.println("After a %= b: a = " + a);

		// 7. Bitwise AND and Assign (&=)
		a = 10;
		b = 7;
		a &= b; // a = a & b
		System.out.println("After a &= b: a = " + a);

		// 8. Bitwise OR and Assign (|=)
		a |= b; // a = a | b
		System.out.println("After a |= b: a = " + a);

		// 9. Bitwise XOR and Assign (^=)
		a ^= b; // a = a ^ b
		System.out.println("After a ^= b: a = " + a);

		// 10. Left Shift and Assign (<<=)
		a <<= 2; // a = a << 2
		System.out.println("After a <<= 2: a = " + a);

		// 11. Right Shift and Assign (>>=)
		a >>= 1; // a = a >> 1
		System.out.println("After a >>= 1: a = " + a);

		// 12. Unsigned Right Shift and Assign (>>>=)
		a >>>= 1; // a = a >>> 1
		System.out.println("After a >>>= 1: a = " + a);
	}
}
