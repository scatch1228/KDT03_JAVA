package com.ruby.java.ch10.컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {

	public static void main(String[] args) {
	
		ArrayList<String> list = new ArrayList<>();
		list.add("Seoul"); list.add("Beijing"); list.add("Shanghai");
		list.add("Seoul"); list.add("Tokyo"); list.add("NewYork");

		
		list.add("London"); list.add("Rome"); list.add("Bangkok");
		list.add("Beijing"); list.add("Tokyo"); list.add("Seoul");
		
		/*
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}*/
		System.out.println("1 : " + list.toString());
		
		//add with index
		list.add(1,"LA");	//print(2,list);
		System.out.println("2 : " + list.toString());
		//index
		System.out.println("3 : " + list.indexOf("Seoul"));
		System.out.println("4 : " + list.lastIndexOf("Seoul"));
		//remove
		list.remove("LA");
		System.out.println("5 : " + list.toString());
		list.remove(2);
		System.out.println("6 : " + list.toString());
		//contains
		System.out.println("7 : " + list.contains("LA"));
		System.out.println("8 : " + list.contains("Bangkok"));
		//toArray
		Object obj[] = list.toArray();
		System.out.println("9 : " + Arrays.toString(obj));
		
		int[] x = {1,2};
		ArrayList<int[]> intlist = new ArrayList<>();
		intlist.add(x);
		System.out.println(intlist.get(0)[1]);
	}

}
