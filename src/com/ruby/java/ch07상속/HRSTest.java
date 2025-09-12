package com.ruby.java.ch07상속;
abstract class Employee2 {//추상 클래스
	String name;
	int salary;
	public abstract void calcSalary();//추상 메소드
	public abstract void calcBonus();
	
	public Employee2() {}//상속되어서 잘 구동되는지 확인
	public Employee2(String name, int salary) {
		this.name=name;
		this.salary=salary;
	}
}
abstract class Salesman extends Employee2 {//307페이지 하단 밑에서 두번째 문단
	int salesQty;
	
	@Override
	public void calcSalary() {//calcBonus() 메서드를 구현하지 못했으므로 Salesman 클래스도 추상화 되어야됨.
		System.out.println("Salesman 급여 = 기본급+판매수당*판매량");
	}
	
	public Salesman() {}
	
	public Salesman(String name, int salary, int salesQty) {
		super(name, salary);
		this.salesQty=salesQty;
	}
	
}
class DomesticSalesman extends Salesman {
	int domesticSalesQty;
	
	@Override
	public void calcBonus() {//부모인 Salesman이 구현하지 못한 calcBonus() 메서드를 자식이 완성함. 따라서 추상클래스가 될 필요가 없음.
		System.out.println("DomesticSalesman 보너스 = 기본급* 0.01");
	}
	
	public DomesticSalesman() {}
	
	public DomesticSalesman(String name, int salary, int salesQty, int domesticSalesQty) {
		super(name, salary, salesQty);
		this.domesticSalesQty=domesticSalesQty;
	}
	@Override //바깥 파일에서 오버라이드함
	public String toString() {
		return name + salary + salesQty + domesticSalesQty;
	}
}
class Consultant extends Employee2 {//추상메서드를 모두 구현했으므로 추상클래스가 될 필요가 없음.
	int consultingHours;
	@Override
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급+컨설팅단가 * 컨설팅 시간");
	}
	@Override
	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급* 0.02");
	}
}
class Manager extends Employee2 {
	int teamNumbers;
	@Override
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급+관리자단가 * 팀수");
	}
	@Override
	public void calcBonus() {
		System.out.println("Manager 보너스 = 기본급* 0.03");
	}
}
public class HRSTest {

	public static void main(String[] args) {
		//Salesman s1 = new Salesman("대창모",100,30);//추상 클래스라서 인스턴스 생성이 안됨
		//Employee2 e = new Employee2();
		Employee2 s = new DomesticSalesman("대창모",100,30,20); //자식인스턴스를 부모클래스 타입의 참조변수로 선언가능
		DomesticSalesman d = new DomesticSalesman("구창모",300,20,10);
		Consultant c = new Consultant();
		Manager m = new Manager();
		s.calcSalary();
		d.calcSalary();
		d.calcBonus();
		c.calcSalary();
		m.calcSalary();
		System.out.println(d);
		System.out.println(s);

	}

}
