package com.ruby.java.ch06객체구현;

public class Member2 {
	private String name;
	private int age;
	
	public Member2() {
		this("guest");
		System.out.println("Member() 생성자 실행");
	}
	
	public Member2(String name) {
		this(name,0);
	//	System.out.print("Member(String) 생성자 실행: ");
	//	System.out.println(name); 
		
	}
	
	public Member2(String name, int age) {
		System.out.print("Member(String, int) 생성자 실행: ");
	//	System.out.println(name+ ", " + age);
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name + ":" + age;
	}
	
	public void setName(String name) {
		
	}
	
	public static void main(String[] args) {
	//	System.out.println("main() 메서드 실행");
		Member2 m1 = new Member2();
		Member2 m2 = new Member2("Amy");
		Member2 m3 = new Member2("Amy",23);
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}

}
