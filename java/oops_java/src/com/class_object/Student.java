package com.class_object;

public class Student {
	String st_n,st_sec;
	int st_cl,st_rn;
	public String isStudent() {
		return "is a student";
	}
public static void main(String[] args) {
	Student sc = new Student();{
		sc.st_n = "Cal";
		sc.st_rn = 1;
		sc.st_cl = 7;
		sc.st_sec = "A";
		String res = sc.isStudent();
		System.out.println(sc.st_n);
		System.out.println(sc.st_rn);
		System.out.println(sc.st_cl);
		System.out.println(sc.st_sec);
		System.out.println(res);
	}
	System.out.println();
	Student scc = new Student();{
		scc.st_n = "Declan";
		scc.st_rn = 2;
		scc.st_cl = 9;
		scc.st_sec = "B";
		String ress = scc.isStudent();
		System.out.println(scc.st_n);
		System.out.println(scc.st_rn);
		System.out.println(scc.st_cl);
		System.out.println(scc.st_sec);
		System.out.println(ress);
	}
}
}
