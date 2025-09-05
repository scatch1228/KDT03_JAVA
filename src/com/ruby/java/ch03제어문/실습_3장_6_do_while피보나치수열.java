package com.ruby.java.ch03제어문;

import java.util.Scanner;

/*
 * 피보나치 수열: 0 1 1 2 3 5 8 ...
 * int n = sc.nextInt(); //항의 수
 * int first = 0;
 * int second = 1;
 * sysout(first);
 * do {
 *    sysout(second)
 *    int next = first + second;
 *    first = second;
 *    second = next;
 * } while();
 * 
 */
public class 실습_3장_6_do_while피보나치수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("do-while문 실습에 필요한 n 값을 입력:");
		int n = sc.nextInt();
		
		int F1=0;
		int F2=1;
		int F3=1;
		System.out.println(F1);
		System.out.println(F2);
		int i=0;
		do {
			F3=F2+F1;
			System.out.println(F3);
			F1=F2;
			F2=F3;
			i++;
		}while(i<n-1);
		
		System.out.println("while문 실습에 필요한 m 값을 입력:");
		int m=sc.nextInt();
		
		F1=0;
		F2=1;
		F3=1;
		System.out.println(F1);
		System.out.println(F2);
		int j=0;
		while(j<m-1) {
			F3=F2+F1;
			System.out.println(F3);
			F1=F2;
			F2=F3;
			j++;
		}
	}
}
