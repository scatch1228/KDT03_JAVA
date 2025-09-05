package com.ruby.java.ch02데이터타입;

import java.util.Scanner;

public class 실습_2_5타입변환 {

	public static void main(String[] args) {
		// 정수형에서 실수형으로 변환 (묵시적 형 변환)

		/*

		* 정수형 변수를 화면에서 입력받아 double 변수로 변환하여 출력하는 코드를 작성한다.

		* 출력은 "정수변수값 = **, 실수변수값 = **"

		*/
		Scanner sc = new Scanner(System.in);
		
		int integer1=sc.nextInt();
		double real1=(double)integer1;
		System.out.println("정수변수값=" +integer1 + ", 실수변수값="+real1 );


		// 실수형에서 정수형으로 변환 (명시적 형 변환)

		/*

		* 실수형 변수 값을 화면에서 입력받아 정수로 변환하는 코드를 작성한다.

		* 출력은 "실수변수값 = **, 정수변수값 = **

		*/
		
		double real2= sc.nextDouble();
		int integer2=(int) real2;
		System.out.println("실수변수값="+real2+ ", 정수변수값=" +integer2  );

		
		
		MinBillCount.a(sc);
		
	}

}
class MinBillCount {
	
	static void a(Scanner sc) {
	
	int n=sc.nextInt()/1000;
	
	int fifty=n/50;
	int mod50=n%50;
	
	int ten=mod50/10;
	int mod10=mod50%10;
	
	int five=mod10/5;
	int mod5=mod10%5;
	
	System.out.println(fifty);
	System.out.println(ten);
	System.out.println(five);
	System.out.println(mod5);
	System.out.println(fifty*50000+ten*10000+five*5000+mod5*1000);
	}
}
