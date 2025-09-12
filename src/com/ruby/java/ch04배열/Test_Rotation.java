package com.ruby.java.ch04배열;

import java.lang.Math;

public class Test_Rotation {

	public static void main(String[] args) {
		double degrees = 45.0;

        // convert degrees to radians
        double radians = Math.toRadians(degrees);

        // sin() method to get the sine value
        double sinValue = Math.sin(radians);

        // prints the sine value
        System.out.println("sin(" + degrees + ") = " + sinValue);

      
        
	}//void main
	
	public static void rotate(int[] arg) {
		
		int[] A = {0,0,0};
//		int[] R = {{Math.cos(),(Math.sin())*(-1),0},{Math.sin(),Math.cos(),0},{0,0,1}};
		
	}//int rotate

}//public class
