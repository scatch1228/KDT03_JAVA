package com.ruby.java.ch04배열;

public class Test37 {

	public static void main(String[] args) {
		int[] score = {90, 85, 78, 100, 98};
		double sum = 90;
		double avg =0.0;
		int max = 90;
		int min = 90;
		
		for (int i=1; i < score.length; i++) {
			sum += score[i];
			if (max < score[i])
				max=score[i];
			if (min > score[i])
				min=score[i];
		}
		avg=sum/score.length;
		System.out.println("총점은 "+ sum);
		System.out.println("평균은 "+ avg);
		System.out.println("최댓값은 "+ max);
		System.out.println("최솟값은 "+ min);
		
		char z = (char) (25+'A');
		int y = 25+'A';
		System.out.println(z + "---" + y );

	}

}
