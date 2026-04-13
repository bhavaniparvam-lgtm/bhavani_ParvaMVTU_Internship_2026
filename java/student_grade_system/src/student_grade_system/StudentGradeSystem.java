package student_grade_system;
import java.util.*;

public class StudentGradeSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter marks:");
		int marks=sc.nextInt();
		if(marks>=90) {
			System.out.println("Grade:A");
			System.out.println("Grade Description:Excellent");
		}
		else if(marks>=75) {
			System.out.println("Grade:B");
			System.out.println("Grade Description:Good");
		}
		else if(marks>=60) {
			System.out.println("Grade:C");
			System.out.println("Grade Description:Average");
		}
		else if(marks>=50) {
			System.out.println("Grade:D");
			System.out.println("Grade Description:Pass");
		}
		else {
			System.out.println("Grade:F");
			System.out.println("Grade Description:Fail");
		}
		sc.close();
	}
}
