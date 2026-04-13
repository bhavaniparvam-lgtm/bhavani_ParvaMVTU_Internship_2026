package looping_statements;

public class ForLoop {
	public static void main(String[] args) {
		/*
		 * For:
		 * ====
		 * for(ini ; con ; inc/dec){
		 * //code
			}
			*if you know the no. of iteration
	*/
		int num=5;
		for(int i=1;i<=10;i++) {
			System.out.println(num+"*"+i+"="+(num*i));
		}
	}
}
