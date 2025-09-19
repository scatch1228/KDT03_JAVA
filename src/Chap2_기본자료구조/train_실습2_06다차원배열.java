package Chap2_기본자료구조;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 *  함수에서 배열을 리턴할 때 리턴 타입 정의할 수 있어야 한다
 */

import java.util.Arrays;
import java.util.Random;
public class train_실습2_06다차원배열 {

	private static void inputData(int[][] matrix) {
		Random n = new Random(11);
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = n.nextInt(10);
			}
		}
	}
	
	private static void showData(String msg, int[][] matrix) {
		System.out.println(msg);
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static int[][] addMatrix(int[][] matrix1,int[][] matrix2) {
		if(matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
			System.out.println("행렬사이즈가 다르면 더할 수 없습니다.");
			return null;
		}//방어코드
		
		int[][] addMatrix = new int[matrix1.length][matrix1[0].length];
		
		for (int i=0; i<matrix1.length; i++) {
			for (int j=0; j<matrix1[0].length; j++) {
				addMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		
		return addMatrix;
	}
	
	private static int[][] multiplyMatrix(int[][] matrix1,int[][] matrix2) {
		
		return null;
	}
	
	private static int[][] transposeMatrix(int[][] matrix) {
		
		return null;
	}
	
	private static int[][] multiplyMatrixTransposed(int[][] matrix1,int[][] matrix2) {
		
		return null;
	}
	
	private static boolean equals(int[][] matrix1,int[][] matrix2) {
		
		return false;
	}
	
	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];

		inputData(A);inputData(B);
		int [][]D = A.clone();//교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println();
		
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		System.out.println();
		
		int [][]E = addMatrix(A,D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
		System.out.println();
		
		C = multiplyMatrix(A,B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);
		System.out.println();

		int [][]F = transposeMatrix(B);
		System.out.println("F[3][2] = ");
		showData("행렬 F", F);
		System.out.println();
		
		C= multiplyMatrixTransposed(A,F);
		showData("행렬 곱셈 결과-전치행렬 사용", C);
		boolean result = equals(A,C);
		if (result)
			System.out.println("행렬 A,C는 equal이다");
		else
			System.out.println("행렬 A,C는 equal 아니다");
	}
	
}

