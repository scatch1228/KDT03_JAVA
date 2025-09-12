package com.ruby.java.ch07상속;

class Rectangle{
	int width;
	int height;
	
	public Rectangle() {}
	
	public Rectangle(int w, int h) {
		width=w;
		height=h;
	}
	@Override
	public String toString() {
		return "rectangle 값: ("+ width + ", " + height + ")";
	}
}

public class Test_Rectangle {
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		System.out.println(r);

	}

}
