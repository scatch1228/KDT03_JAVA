package com.ruby.java.ch10.컬렉션;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Test02 {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		list.add("Seoul"); list.add("Beijing"); list.add("Shanghai");
		list.add("Seoul"); list.add("Tokyo"); list.add("NewYork");
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("========");
		
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		Vector<String> vector = new Vector<>();
	}

}
