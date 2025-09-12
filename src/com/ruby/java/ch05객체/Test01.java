package com.ruby.java.ch05객체;

public class Test01 {
	
	static int[] test(int... v) {
		System.out.print(v.length+" : ");
		for(int x:v)
			System.out.print(x+" ");
		System.out.println();
		return v;
	}
	
	public static void main(String[] args) {
		test(1);		
		test(1,2);		
		test(1,2,3);			
		test(4,5,6);			
		test(1,5,6,10,90);			
		
		System.out.println(test(1,2,3,4,5)[3]);
	}

}
