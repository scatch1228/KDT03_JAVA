package com.ruby.java.ch13.Generic;

/*
class Bag<T,N> {
	private T thing;
	private N name;
	
	Bag(T thing) {
		this.thing = thing;
	}
	
	Bag(T thing, N name) {
		this.name = name;
		this.thing = thing;
	}
	
	T getThing() {
		return thing;
	}
	
	void setThing(T thing) {
		this.thing = thing;
	}
	
	N getName() {
		return name;
	}
	
	void setName(N name) {
		this.name = name;
	}
	
	void showType() {
		System.out.println("Type of T: " + thing.getClass().getName());
	}
}

class Book {}
class PencilCase {}
class Notebook {}

public class BagTest {

	public static void main(String[] args) {
		/*Bag<Book> bag0 = new Bag<>(new Book());
		Bag<PencilCase> bag1 = new Bag<>(new PencilCase());
		Bag<Notebook> bag2 = new Bag<>(new Notebook());
	
		bag0.showType();
		bag1.showType();
		bag2.showType();
		
		Book book = (Book)bag.getThing();
		PencilCase pc = (PencilCase)bag1.getThing();
		Notebook nb = (Notebook)bag2.getThing();
		
		//bag1 = bag2; //오류: 타입 미스매치*/
		
/*
		Bag<Book, String> bag = new Bag<>(new Book(), "Math");
		
		bag.showType();
		
		Book book = bag.getThing();
		String name = bag.getName();
		
		System.out.println("Thing is: "+bag.getThing());
		System.out.println("Name is: "+bag.getName());
	}

}*/
