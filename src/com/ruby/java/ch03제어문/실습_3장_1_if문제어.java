package com.ruby.java.ch03제어문;

import java.util.Scanner;

public class 실습_3장_1_if문제어 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("if문 실습:");
		System.out.print("택배 무게를 입력하세요: ");
		int wgt = sc.nextInt();

		/*
		 * 무게에 따라 택배 요금 계산하여 출력한다
		 * 1000 이하 3000
		 * 1000 < w <= 5000 5000
		 * 5000 < w <= 10000 8000
		 * 10000 < w  12000
		 * 
		 * 출력: 택배 요금은 0000원입니다
		 */
		
		int fare=0 ;
		if (wgt<1000)
			fare=3000;
		else if (1000 < wgt & wgt <= 5000)
			fare=5000;
		else if (5000 < wgt & wgt <= 10000)
			fare=10000;
		else if (10000 < wgt)
			fare=12000;
		
		System.out.println("택배 요금은 " + fare + " 입니다.");
		sc.close();
	}
}
