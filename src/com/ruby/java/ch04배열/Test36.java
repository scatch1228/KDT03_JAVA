package com.ruby.java.ch04배열;

public class Test36 {

	public static void main(String[] args) {
		char letter = 'A';
		char[] alphabet = new char[35];
		
		for (int i=0; i < alphabet.length; i++) {
			alphabet[i] = (char) (letter + i);
			int x=letter + i;
		}
		
		for (char c : alphabet) {
			System.out.println(c);
		}

	}

}
