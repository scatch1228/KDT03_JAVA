package com.ruby.java.ch14;

@FunctionalInterface
interface NumberFunc{
	int func(int n);
}

public class Test05 {

	public static void main(String[] args) {
		NumberFunc sum = (n) -> {
			int result = 0;
			for (int i = 0; i<= n; i++) {
				result += i;
			}
			return result;
		};//lambda
		
		NumberFunc factorial = (n) -> {
			int result = 1;
			for (int i = 1; i<= n; i++) {
				result *= i;
			}
			return result;
		};//lambda
		
		System.out.println("sum^10_1 = " +sum.func(10));
		System.out.println("sum^100_1 = " +sum.func(100));
		System.out.println("5! = "+factorial.func(5));
	}

}
