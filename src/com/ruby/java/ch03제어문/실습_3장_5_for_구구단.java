package com.ruby.java.ch03제어문;
/*
 * 구구단 출력
 * int dan = sc.nextInt()
 * for(;;) {
 *     //3x1 = 3
 *     //3x2 = 6 등으로 출력
 * }
 * 
 */
public class 실습_3장_5_for_구구단 {
	public static void main(String[] args) {
		for (int i=1; i<=9; i++) {
			System.out.println("-----");
			for (int j=1; j<=9; j++) {
				System.out.println(i+"*"+j +"=" + i*j);
			}
		}
	}
}
