package com.ruby.java.ch14;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test14 {

	public static void main(String[] args) {
		Function<String, Integer> func = (s) -> {
			int cnt =0;
			String[] word = s.split(" ");
			cnt = word.length;
			return cnt;
		
		};// <T>의 타입은 직접 지정
		//String (s)을 받아서 Integer (cnt)을 리턴하는 메서드를 람다식으로 구현
		
		//test15 pg 699
		int wordCnt = func.apply("고개를 들어 별들을 보라");
		System.out.println("단어수 :" + wordCnt);
		
		Predicate<Integer> func2 = (n) -> n%2==0;
		//parameter 하나로 boolean을 리턴하는 메서드를 람다식으로 구현
		if(func2.test(123))
			System.out.println("even");
		else
			System.out.println("odd");
		
		//test16 pg700
		Consumer<Date> date = (d) -> { //parameter 하나로 특정 데이터를 가져오는 메서드를 람다식으로 구현
			String s = new SimpleDateFormat("YY-MM-dd").format(d); //생성자 메소드로 람다식 구현
			System.out.println(s);
		};
		
		date.accept(new Date());
	}
//위에 있는 func, func2, date는 모두 interface의 abstract 메서드를 사용하기 위해 만드는 람다객체.
//.apply, .test, .accept는 각각의 interface에 구현된 abstract method. <T>에 specified된 타입들을 parameter로 받음
}
