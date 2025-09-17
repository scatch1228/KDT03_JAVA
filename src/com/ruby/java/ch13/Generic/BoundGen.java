package com.ruby.java.ch13.Generic;

class Bag<T extends Solid> {
	private T thing;
	private String owner;
	
	Bag(T thing) {
		this.thing = thing;
	}
	
	
	T getThing() {
		return thing;
	}
	
	void setOwner(String name) {
		owner = name;
	}
	
	String getOwner() {
		return owner;
	}
	
	//Wild Card: not specify the parameter type of generic class
	boolean isSameOwner(Bag<?> obj) {
		if(this.owner.equals(obj.getOwner())) {
			return true;
		}
		return false;
	}

	void showType() {
		System.out.println("Type of T: " + thing.getClass().getName());
	}
}

class Solid{}
class Book extends Solid {}
class PencilCase extends Solid {}
class Notebook extends Solid {}

class Water {}
class Coffee {}

public class BoundGen {

	public static void main(String[] args) {
		Bag<Book> bag0 = new Bag<>(new Book());
		Bag<PencilCase> bag1 = new Bag<>(new PencilCase());
		Bag<Notebook> bag2 = new Bag<>(new Notebook());

		//Bag<Water> bag3 = new Bag<>(new Water());//오류발생. 타입제한에 걸림. Solid를 extend하는것만 가능
		//Bag<Coffee> bag4 = new Bag<>(new Coffee());//

		bag0.setOwner("Kim");
		bag1.setOwner("Kim");
		bag2.setOwner("Lee");
		boolean result1 = bag0.isSameOwner(bag1);
		boolean result2 = bag0.isSameOwner(bag2);
		
		if(result1) System.out.println("bag0,bag1 same");
		else System.out.println("bag0,bag1 not same");
		
		if(result2) System.out.println("bag0,bag2 same");
		else System.out.println("bag0,bag2 not same");
		
		
		
	}

}
