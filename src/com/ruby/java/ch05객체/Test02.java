package com.ruby.java.ch05객체;

public class Test02 {

	static void test(String name, int... v) {
		System.out.print(name + " : ");
		for(int x : v)
			System.out.print(x + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		test("우정잉", 98,85 ,88);
		test("랄로",90 ,95 ,92,87);
		test("파카", 80,98);

	}

}
