package com.ruby.java.ch06객체구현;

//6장 실습 구현 - this 사용 생성자 구현 

class Employee {
	int pid;
	String name;
	int age;
	int eno;
	String dept;
	float salary;

	Employee() {
	}


	Employee(int i, String string) {
		pid = i;
		name = string;
	}


	Employee(int i, String string, int j, int k) {
		pid = i;
		name = string;
		age = j;
	}


	Employee(int i, String string, int j, int k, String string2, int l) {
		pid = i;
		name = string;
		age = j;
		eno = k;
		dept = string2;
		salary = 1;
	}

	  //생성자가 하나도 없으면 컴파일러가 default 생성자를 자동 생성
	public String toString() {
		return pid +",	" + name +",	" + age +",	" + eno +",	" + dept +",	" + salary;
	}
	 
}
public class 실습6_4Emp객체 {

	public static void main(String[] args) {

		Employee[] arr = new Employee[5];
		arr[0] = new Employee();
		arr[1] = new Employee(3, "Park");
		arr[2] = new Employee(3, "Park", 30, 2001);
		arr[3] = new Employee(4, "Choi", 35, 2002, "Engineering", 4000);
		arr[4] = new Employee(5, "Kang", 22, 1003, "Physics", 4);
		
		for (Employee p : arr) {
			System.out.println(p.toString());
		}

	}

}
