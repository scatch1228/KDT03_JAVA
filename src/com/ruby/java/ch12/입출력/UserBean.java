package com.ruby.java.ch12.입출력;

import java.io.Serializable;

public class UserBean implements Serializable {
	
	private String id;
	private String name;
	private String tel;
	private String address;
	
	public UserBean() {}

	public UserBean(String id, String name, String tel, String address) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	
	
	@Override
	public String toString() {
		return "UserBean [id =" + id + ", name =" + name + ", tel="+tel+ ", address=" +address+"]";
	}
	
	public void test() {}
} 

