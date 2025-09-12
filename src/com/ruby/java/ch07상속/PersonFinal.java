package com.ruby.java.ch07상속;

/*
//class Person2 {
class Person2 {
	private final String ssn_id; //final = constant 불변
	// private final String ssn_id = "2025_09";
	private String name;
	private int age;

	public Person2() {// 오류 - ssn_id가 할당되지 않을 경우 이 코드에서 에러남
		System.out.println("Person2() 생성자 실행!");
	}

	public Person2(String sid, int age) {// final 변수 초기화
		ssn_id = sid; //이미 ssn_id가 할당됐다면 이 코드에서 에러남
		this.age = age;
		System.out.println("Person2(sid, age) 생성자 실행!");
	}

	void set_ssn_id(String sid) {
		ssn_id = sid;// 오류 - 이유는?
	}

	public final String toString() {
		return name + ", " + age;
	}
}

final class Student2 extends Person2 {//final class는 자손을 가질 수 없다
	String dept;

	public Student2(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}
	public final String toString() { // final method는 오버라이드 할 수 없다
		return super.toString() + ", " + dept;
	}
}

public class PersonFinal {

	public static void main(String[] args) {
		Student2 s2 = new Student2("딥러닝");
		System.out.println(s2);

	}

}*/

