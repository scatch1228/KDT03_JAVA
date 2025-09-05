package com.ruby.java.ch04배열;
/*
 * 배열 사용없이 변수 5개를 사용하여 5명 점수의 평균 구하기
 * int score1,score2,score3, score4, score5;
 */
public class 실습_4_1_변수들사용 {
	//5명 점수를 score1 등의 변수로 초기화: 49, 91, 87, 67, 73
	//최대 점수, 최소 점수, 평균 점수 계산하는 코드 구현
	
	public static void main(String[] args) {
	
		int s1=49;
		int s2=91;
		int s3=87;
		int s4=67;
		int s5=73;
		double sum=s1+s2+s3+s4+s5;
		
		double avg = sum/5;
	
		int max = s1 ;
		if (max<s2) {
		max=s2;
		}
		if (max<s3) {
		max=s3;
		}
		if (max<s4) {
		max=s4;
		}
		if (max<s5) {
		max=s5;
		}
	
		int min = s1 ;
		if (min>s2) {
		max=s2;
		}
		if (min>s3) {
		max=s3;
		}
		if (min>s4) {
		max=s4;
		}
		if (min>s5) {
		max=s5;
		}
		
		System.out.println(avg);
		System.out.println(max);
		System.out.println(min);
	}
}
