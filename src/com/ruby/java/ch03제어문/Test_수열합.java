package com.ruby.java.ch03제어문;

public class Test_수열합 {

	public static void main(String[] args) {
		int n=0;
		for (int i=0; i< 100; i++) {
			if (n>10)
				continue;
			n += i*2;
			if (n>20)
				break;
		}
	}

}
