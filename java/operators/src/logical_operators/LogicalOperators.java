package logical_operators;

public class LogicalOperators {
	public static void main(String[] args) {
		//Logical operators
		int a=2;
		int b=3;
		int c=4;
		boolean d=a>b;
		boolean e=a>c;
		//logical and &&
		System.out.println("and:"+(d&&e));
		//logical or ||
		System.out.println("or:"+(d||e));
		//logical not !
		System.out.println("not:"+!(d&&e));
	}
}
