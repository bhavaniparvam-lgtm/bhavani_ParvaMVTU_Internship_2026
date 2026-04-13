package conditional_statements;
import java.util.*;

public class Conditional1 {
	public static void main(String[] args) {
		/*
		 *conditional statements:
		 *=======================
		 *1. if
		 *2.if-else
		 *3.else-if
		 *4.switch 
		 * */
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your age");
		int age=sc.nextInt();
		if(age>18) {
			System.out.println("valid");
		}
		else {
			System.out.println("invalid");
		}
		sc.close();
		switch(age) {
		case 1:{
			System.out.println("case 1");
			break;
		}
		}
	}
}
