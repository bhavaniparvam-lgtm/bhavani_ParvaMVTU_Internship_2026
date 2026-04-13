package arithematic_operators;

public class TernaryOperators {
	public static void main(String[] args) {
		//ternary/conditional operators
		int a=5;
		int b=8;
		int c=3;
		int max=(a>b)?a:b;
		System.out.println("max:"+max);
		int min=(b>a)?a:b;
		System.out.println("min:"+min);
		//nested ternary
		int m=(a>b)?(a>c)?a:c:(b>c)?b:c;
		System.out.println("max:"+m);
	}
}
