package strings_java;

public class String2 {
	public static void main(String[] args) {
		/*
		 * String comparison:
		 * ==================
		 * 1.  .equals()--->it will check the value
		 * 2. == -----> it will check both value and reference
		 * 3. compareTo ---> it will check bytes
		 * if two equal --> 0
		 * if str1 > str2 --> >0
		 * if str1 < str2 --> <0
		 * */
		String str1 = "Cal";//scp
		String str2 = new String("Cal");//heap
		String str3 = "Cal";
		String str4 = new String("Cal");
		System.out.println(str1);
		System.err.println(str2);
		
		System.out.println("str1.str2: "+str1.equals(str2));
		System.out.println("str1 == str2: "+(str1==str2));
		System.out.println("str1 == str3: "+(str1==str3));
		System.out.println("str2 == str4: "+(str2==str4));
		
		System.out.println("str1 compare str3: "+str1.compareTo(str3));
		System.out.println("str1 compare str4: "+str1.compareTo(str4));
	}
}
