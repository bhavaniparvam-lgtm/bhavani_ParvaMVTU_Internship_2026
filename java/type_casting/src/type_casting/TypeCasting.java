package type_casting;
import java.util.*;

public class TypeCasting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer number");
		int a= sc.nextInt();
		double b= a;
		int c=(int)b;
		System.out.println("Original integer value:"+a);
		System.out.println("After Implicit Casting(int to double):"+b);
		System.out.println("After Explicit Casting(double to int):"+c);
		sc.close();
	}
}
