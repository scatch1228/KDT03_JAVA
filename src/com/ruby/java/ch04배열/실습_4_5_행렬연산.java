package com.ruby.java.ch04배열;

import java.util.Random;

/*
 * 2차원 배열과 행렬 연산
 * 
 * 학습 목표
 *  1) 2차원 배열 만들기
 *  2) 난수로 배열 값 채우기
 *  3) 배열 간 덧셈, 곱셈, 전치(transpose) 개념 익히기
 *  4) 두 배열이 같은지 비교하기
 *  5) 배열을 테이블 형태로 출력하기
 *  
 */

public class 실습_4_5_행렬연산 {
    public static void main(String[] args) {
//    	1. 3줄 5칸짜리 표 A를 만든다.
//
//    	A[3][5]는 3명의 학생이 5과목 시험 본 점수표라고 생각하자.
//
//    	점수는 0~99 사이의 무작위 숫자로 채운다.
    	
    	Random rd = new Random();
    	
    	int[][] A = new int [3][5];
    	
    	for (int i=0; i<3; i++) {
    		for (int j=0; j<5; j++) {
    			A[i][j] = rd.nextInt(100);
    		}
    	}
    	
    	System.out.println("A는 이렇게 생김");
    	for (int i=0; i<3; i++) {
    		System.out.println("\n");
    		for (int j=0; j<5; j++) {
    			System.out.print(A[i][j] + "  ");
    		}
    	}
    	
    	System.out.println("\n");
    	System.out.println("==========\n");
    	
//    2. 같은 크기의 표 B도 만들어서 무작위 점수로 채운다.
//
    	int[][] B = new int [3][5];
    	
    	for (int i=0; i<3; i++) {
    		for (int j=0; j<5; j++) {
    			B[i][j] = rd.nextInt(100);
    		}
    	}
    	
    	System.out.println("B는 이렇게 생김");
    	for (int i=0; i<3; i++) {
    		System.out.println("\n");
    		for (int j=0; j<5; j++) {
    			System.out.print(B[i][j] + "  ");
    		}
    	}
    	
    	System.out.println("\n");
    	System.out.println("==========\n");
    	
//    3. C = A + B
//
//    	A와 B의 각 자리에 있는 값을 더해서 C라는 새로운 표를 만든다.
//
//    	예: C[0][0] = A[0][0] + B[0][0]
//
    	
    	int[][] C = new int [3][5];
    	
    	for (int i=0; i<3; i++) {
    		for (int j=0; j<5; j++) {
    			C[i][j] = A[i][j]+B[i][j] ;
    		}
    	}
    	
    	System.out.println("C는 이렇게 생김");
    	for (int i=0; i<3; i++) {
    		System.out.println("\n");
    		for (int j=0; j<5; j++) {
    			System.out.print(C[i][j] + "  ");
    		}
    	}
    	
    	System.out.println("\n");
    	System.out.println("==========\n");
    	
//    4. 5줄 4칸짜리 표 D를 만든다.
//
//    	D[5][4]는 예를 들어 과목별 프로젝트 점수라고 생각해보자.
    	
    	int[][] D = new int [5][4];
    	
    	for (int i=0; i<5; i++) {
    		for (int j=0; j<4; j++) {
    			D[i][j] = rd.nextInt(100) ;
    		}
    	}
  
    	System.out.println("D는 이렇게 생김");
    	for (int i=0; i<5; i++) {
    		System.out.println("\n");
    		for (int j=0; j<4; j++) {
    			System.out.print(D[i][j] + "  ");
    		}
    	}
    	
    	System.out.println("\n");
    	System.out.println("==========\n");
    	
//
//    5. E = A × D (행렬 곱셈)
//
//    	A(3x5)와 D(5x4)를 곱해서 E(3x4)라는 표를 만든다.
//
//    	E[i][j] = A[i][0]*D[0][j] + A[i][1]*D[1][j] + ... + A[i][4]*D[4][j]
//
    	
    	int[][] E = new int [3][4];
    	
    	for (int i=0; i<3; i++) {
    		for (int j=0; j<4; j++) {
    			int sum = 0;
    			for (int k=0; k<5; k++) {
    				sum += A[i][k]*D[k][j];
    			}
    			E[i][j]= sum;
    		}
    		
    	}
    	
    	
//    6. 2차원 배열을 테이블 형태로 출력한다 
    	for (int i=0; i<3; i++) {
    		System.out.println("\n");
    		for (int j=0; j<4; j++) {
    			System.out.print(E[i][j] + "  ");
    		} 
    	}
    }
}
