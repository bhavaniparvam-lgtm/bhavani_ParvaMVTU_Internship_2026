package com.streamapi;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI2 {
	public static void main(String[] args) {
		List<String> name = Arrays.asList("callahan","rowan","declan","murthy","mahesh");
		List<String> collect = name.stream().filter((s)->s.startsWith("m")).collect(Collectors.toList());
		System.out.println(collect);
		
		List<Integer> num = Arrays.asList(1,3,4,5,2,6,7,8,90,2);
		List<Integer> res = num.stream().map(ele -> ele*ele).collect(Collectors.toList());
		System.out.println(res);
		Stream<Integer> stream =  num.stream();		
		Stream<Integer> map = stream.map(ele->ele*ele);
		List<Integer> res1 = map.collect(Collectors.toList());
		System.out.println(res1);
	}
}
