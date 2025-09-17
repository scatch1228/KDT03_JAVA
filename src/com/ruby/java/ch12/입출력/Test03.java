package com.ruby.java.ch12.입출력;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test03 {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("이름을 입력하세요");
			String name = br.readLine();
			System.out.println("Hello, "+name);
		}//try
			catch (Exception e) {
				e.printStackTrace();
			}//catch
	}

}
