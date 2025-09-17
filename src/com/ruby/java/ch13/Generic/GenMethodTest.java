package com.ruby.java.ch13.Generic;

public class GenMethodTest {

	static <T extends Number, V extends T> boolean isInclude(T num, V[] arr) {
		for (int i=0; i < arr.length; i++) {
			if (arr[i]==num) return true;
		}
		return false;
	}
	/*
	static <S extends String, W extends S> boolean has(S num, W[] arr) {
		for (int i=0; i < arr.length; i++) {
			if (arr[i]==num) return true;
		}
		return false;
	}*/
	
	public static void main(String[] args) {
		Integer[] inum = {1,2,3,4,5};
		Double[] dnum = {1.0,2.0,3.0,4.0,5.0};
		String[] snum = {"one", "two", "three" , "four", "five"};
		
		boolean b1 = isInclude(3,inum); System.out.println("result: " + b1);
		boolean b2 = isInclude(5.0,dnum); System.out.println("result: " + b2);
		//boolean b3 = has("one",dnum); System.out.println("result: " + b3);
	
		GenMethodTest.<Integer, Integer>isInclude(3,inum);
		GenMethodTest.<Double, Double>isInclude(5.0,dnum);
		//GenMethodTest.<String, String>has("one",snum);
	}

}
