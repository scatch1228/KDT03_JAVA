package 과제;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Comparator를 사용한 학생 정보 배열 정렬 및 이진 탐색 구현
 * 
 * 다음과 같은 정보를 저장하는 Student 클래스를 정의하고, 
 * 고정된 학생 배열을 Comparator를 사용해 학번(sid) 기준으로 정렬한 뒤,
 * 탐색 대상 학생 객체 배열에 대해 Arrays.binarySearch()를 사용하여 
 * 해당 학번을 가진 학생이 존재하는지 판단하는 프로그램을 작성하시오.
 * 
 * 구현 조건
Student 클래스는 다음 멤버를 포함해야 한다:

String sid; (학번)

String sname; (이름)

String dept; (학과)

생성자: Student(String sid, String sname, String dept)

toString() 메서드: "S002, 철수, Physics" 형식 반환

Student 클래스는 Comparable을 구현하지 않음*/

class Student {
	private String sid;
	private String sname;
	private String dept;
	
	public String getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public String getDept() {
		return dept;
	}

	public Student(String sid, String sname, String dept){
		super();
		this.sid = sid;
		this.sname = sname;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", dept=" + dept + "]";
	}
}//class Student


public class train_실습3_10_객체comparator구현 {
	
	static Student[] students = {
		    new Student("S001", "영희", "Math"),
		    new Student("S003", "민수", "Computer"),
		    new Student("S002", "철수", "Physics"),
		    new Student("S005", "지영", "Biology"),
		    new Student("S004", "준호", "Chemistry")
		};
	
	static void show(Student[] arr) {
		for(Student student : arr) {
			System.out.println(student.toString());
		}
		
	}
	
	public static void main(String args[]) {
		/*show(Student[] arr) 메서드를 작성하여 확장형 for문으로 배열 내용을 출력한다.
		*출력 시 "=== 정렬 전 학생 목록 ==="을 먼저 출력한다.*/
		System.out.println("=== 정렬 전 학생 목록 ===");
		show(students);
		
		/*정렬과 이진 탐색에 사용할 Comparator<Student> 객체를 람다식 또는 익명 클래스로 구현할 것
		*기준: sid 오름차순*/
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				return (s1.getSid()).compareTo(s2.getSid());
			}
			
		});
		System.out.println("=== 정렬 후 학생 목록 ===");
		show(students);
	
	
	/*다음 탐색 대상 배열을 정의하고, 확장형 for문으로 각 항목에 대해 Arrays.binarySearch(배열, key, comparator)로 
	 * 탐색한다.*/
	Student[] targets = {
	    new Student("S002", "철수", "Physics"),
	    new Student("S006", "홍길동", "Law"),
	    new Student("S004", "준호", "Chemistry")
	};
	
	for (Student target : targets) {
		int search;
		search = Arrays.binarySearch(students, target, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return (s1.getSid()).compareTo(s2.getSid());
			}
		} ); //ㅁㅁㅁComparator 익명객체를 람다식으로 구현하는 방법?
		
		/*탐색 결과는 다음과 같이 출력한다:
		"찾은 학생: S002, 철수, Physics"
		"학번 S006인 학생은 존재하지 않습니다."*/
		if (search >= 0) {
			System.out.println("찾은 학생: "+ target.getSid() + ", " + target.getSname() + ", " + target.getDept());
		} else {
			System.out.println("학번 " + target.getSid()+ "인 학생은 존재하지 않습니다.");
		}
	};
	}//main
}//public class

