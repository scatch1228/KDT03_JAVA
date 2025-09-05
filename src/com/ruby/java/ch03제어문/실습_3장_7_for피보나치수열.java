package com.ruby.java.ch03제어문;
/*
 * 피보나치 수열: 0 1 1 2 3 5 8 ...
 * int n = sc.nextInt(); //항의 수
 * int first = 0;
 * int second = 1;
 * sysout(first);
 * for (;;) {
 *    sysout(second)
 *    int next = first + second;
 *    first = second;
 *    second = next;
 * }
 * 
 */
public class 실습_3장_7_for피보나치수열 {
	public static void main(String[] args) {
		int f1=0;
		int f2=1;
		int f3=0;
		System.out.println(f1);
		System.out.println(f2);
		for (int i=0; i<=10; i++) {
			f3=f2+f1;
			f1=f2;
			f2=f3;
			System.out.println(f3);
		}
	}
}
