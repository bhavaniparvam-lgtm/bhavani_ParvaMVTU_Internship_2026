package com.streamapi;

import java.util.ArrayList;
import java.util.List;

public class StreamAPI1 {
	public static void main(String[] args) {
		List<Integer> lis = new ArrayList<Integer>();
		lis.add(10);
		lis.add(12);
		lis.add(13);
		lis.add(11);
		lis.add(15);
		
		//without 
		int count = 0;
		for(int ele : lis) {
			if(ele%2==0) {
				count++;
			}
		}
		System.out.println("Res: "+count);
		
		//with
		long count2 = lis.stream().filter((ele)->ele%2!=0).count();
		System.out.println(count2);
	}
}
