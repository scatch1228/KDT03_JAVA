package com.ruby.java.ch03제어문;

import java.util.Scanner;

/*
 * switch - case 문 실습
 * 음료 자판기 프로그램
 * Scanner sc = new Scanner(System.in)
 * 
 * sysout > ctrl + space 사용하여 코드 자동 생성
 * 
 *  > 단축어로 switch, for, while, do, main에 대하여 코드 자동 생성 실습
 *  
 * sysout("자판기 사용 비용")
 * sysout("1. 커피 - 2000원")
 * sysout("2. 맥주 - 2400원")
 * sysout("3. 콜라 - 1500원")
 * sysout("4. 주스 - 1200원")
 * 
 * int choice = sc.nextInt(); //화면에서 숫자 입력
 * int price;
 * switch(choice) { //switch()에 올 수 있는 변수: byte, short, int, char, string
 *     case 1:
 *     
 *     break;
 *     ...
 *     default:
 * }
 *     
 */
public class 실습_3장_2switch문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("자판기 사용 비용");
		System.out.println("1. 커피 - 2000원");
		System.out.println("2. 맥주 - 2400원");
		System.out.println("3. 콜라 - 1500원");
		System.out.println("4. 주스 - 1200원");
		System.out.println("메뉴를 골라 1,2,3,4를 입력하세여.");
		int choice = sc.nextInt();
		int price=999999;
		switch(choice) {
			case 1: price=2000; break;
			case 2: price=2400; break;
			case 3: price=1500; break;
			case 4: price=1200; break;
			default: System.out.println("벌금을 물겠습니다."); break;
		}
		System.out.println(price+"원 결제되었습니다.");
	}
}
