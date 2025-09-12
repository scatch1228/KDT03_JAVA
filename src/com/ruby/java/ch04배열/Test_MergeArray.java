package com.ruby.java.ch04배열;

import java.util.Arrays;
import java.util.Random;

public class Test_MergeArray {

	public static void main(String[] args) {

		// setups
		Random rd = new Random();

		int[] A = new int[5];
		int[] B = new int[5];
		int[] C = new int[A.length + B.length];

		// generate and print A
		System.out.print("A = [");
		for (int i = 0; i < A.length; i++) {
			A[i] = rd.nextInt(50);
			if (i < A.length - 1) {
				System.out.print(A[i] + ",");
			} else {
				System.out.print(A[i] + "]");
			}
		}

		// generate and print B
		System.out.println("\n");
		System.out.print("B = [");
		for (int i = 0; i < B.length; i++) {
			B[i] = rd.nextInt(50);
			if (i < B.length - 1) {
				System.out.print(B[i] + ",");
			} else {
				System.out.print(B[i] + "]");
			}
		}

		// generate C
		for (int i = 0; i < A.length + B.length; i += 2) {
			C[i] = A[i / 2];
		}
		for (int i = 1; i < A.length + B.length; i += 2) {
			C[i] = B[(i - 1) / 2];
		}

		// print C
		System.out.println("\n");
		System.out.print("C = [");
		for (int i = 0; i < A.length + B.length; i++) {
			if (i < A.length + B.length - 1) {
				System.out.print(C[i] + ",");
			} else {
				System.out.print(C[i] + "]");
			}
		}
		
		String X= "ABCDEFG//";
		
		System.out.println("\n");
		System.out.println("A:"+Arrays.toString(A));
		System.out.println(X.repeat(3));
	}// public static void
}// public class
