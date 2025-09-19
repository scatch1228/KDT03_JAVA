package com.ruby.java.ch14;
//pg661~3

interface MyInterface {
	void print();
}//MyInterface

class MyClass1 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass1");
	}
}//MyClass1

class MyClass2 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass2");
	}
}//MyClass2

public class Test01 {
	
	private static void test(MyInterface mi) {
		mi.print();
	} 
	
	private static MyInterface test2() {
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("test2() 메서드에서 반환된 MyInterface");
			}
		};//mi
		return mi;
	}//test2
	
	public static void main(String[] args) {
	
	MyClass1 mc1 = new MyClass1();
	MyClass2 mc2 = new MyClass2();
	mc1.print();
	mc2.print();
	
	MyInterface mi = new MyInterface() {
		@Override
		public void print() {
			System.out.println("익명클래스로 구현");
		}
	};
	
	test(mc1);
	test(mi);
	
	mi.print();
	
	(new MyInterface() {
		@Override
		public void print() {
			System.out.println("선언, 생성, 호출 한번에" );
		}
	}).print();
	
	MyInterface mi2 = test2();
	mi2.print();
	
	
	}//main

}//public class
