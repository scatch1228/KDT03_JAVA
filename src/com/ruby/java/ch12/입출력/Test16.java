package com.ruby.java.ch12.입출력;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test16 {
	public static void main(String[] args) {
		
		UserBean user = new UserBean("purum", "오정임", "010-1234-1234", "서울");
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.txt"))) {
			out.writeObject(user);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.txt"))) {
			UserBean user2 = (UserBean) in.readObject();
			System.out.println(user2);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main
}
