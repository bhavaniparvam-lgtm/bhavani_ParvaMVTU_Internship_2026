package functions_in_java;

import java.util.Scanner;

public class Functions2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers:");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int res=mul(num1, num2);
		System.out.println("res:"+res);
		int res1 = NewClass.div(num1,  num2);
		System.out.println("div:"+res1);
	}
	//static - no need to create a object. we can access using classname
	//(whenever same class we can call directly)
	public static int mul(int a, int b) {
		return a*b;
	}
}
class NewClass{
	public static int div(int a, int b) {
		return a/b;
	}
}
