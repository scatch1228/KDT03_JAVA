package com.ruby.java.ch04배열;

public class Test40 {
	public static void main(String[] args) {
		int[][] arr=new int[5][5];
		
		int n=1;
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				arr[i][j]=n++;
			}
		}
	
		int lowTri=0;
		for (int i=0; i<5; i++) {
			for (int j=0; j<=i; j++) {
				lowTri += arr[i][j];
			}
		}
		System.out.println(lowTri);
	}
}
