package student_details;
import java.util.*;
public class StudentDetails {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name:");
		String sn = sc.nextLine();
		System.out.println("Enter the usn");
		String usn = sc.nextLine();
		System.out.println("Enter the branch");
		String b = sc.nextLine();
		System.out.println("Enter the percentage");
		float p = sc.nextFloat();
		System.out.println("-----------Student Details----------");
		System.out.println("Name:"+sn);
		System.out.println("USN:"+usn);
		System.out.println("Branch:"+b);
		System.out.println("Percentage:"+p);
		sc.close();
	}
}
