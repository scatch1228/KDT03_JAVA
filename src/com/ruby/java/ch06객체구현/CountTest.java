package com.ruby.java.ch06객체구현;
//public class Count { // 오류가 발생하는 것을 확인 > 이해해야 
// 232페이지 희색 박스 읽기

class Count { //232페이지
	static int totalCount;//메소드 영역에 저장
	int count = 0;//heap 영역에 저장
	public static void print1() { //클래스 메소드
		System.out.println("정적메소드: hello");
	}
	public void show() {
		System.out.println("메소드 : " + count);
	}

}

public class CountTest { //file 이름과 같아야 한다
	public void show() {
		System.out.println("CountTest의 메소드");
	}
	static void showStatic() {//239 페이지의 예제 코드
		System.out.println("클래스 메소드");
	}
	public static void main(String[] args) {
		Count.print1();
		Count.totalCount++;//클래스 필드의 사용 235페이지 (2)클래스 필드 사용
		//Count.count++;//오류 발생
		
		//Count.count = 10;//오류 발생
		
		Count c = new Count();
		c.count=10; //heap에 저장되는건 꼭 참조해줄 변수이름(c)이 있어야됨
		
		showStatic();
		CountTest.showStatic();
		
		Count c1 = new Count();
		// 233페이지의 그림 해석 주의 사항 > totalCount는 static으로 메소드 영역에 저장
		c1.show();

		//다음 2줄의 차이를 이해해야 한다 - 236페이지 (3) 인스턴스 필드와 클래스 필드 예제
		//Count.count++;// 오류 발생 - 이유는?
		c1.count++; //count는 heap에서 호출해야되니까 heap 안에 있는 c1 인스턴스를 참조해서 count를 호출해야됨
		c1.totalCount++;//클래스 필드를 접근하는 바람직한 방법 아님. static은 code 영역에 있기 때문에 클래스로 바로 호출. 
		
		System.out.println("count = " + c1.count + ", totalCount = " + Count.totalCount);
		Count c2 = new Count();
		Count c3 = new Count();

		c1.count++;
		Count.totalCount++;
		c2.count++;
		Count.totalCount++;
		c3.count++;
		Count.totalCount++;

		System.out.println(Count.totalCount + " : " + c1.count);
		System.out.println(Count.totalCount + " : " + c2.count);
		System.out.println(Count.totalCount + " : " + c3.count);
		//show(); //이유는?
		//CountTest.show();//이유는?
		CountTest ct = new CountTest();
		ct.show();
	}
}