package com.ruby.java.ch06객체구현;
class Student3 {
	// 필드
	/*
	 * name, age, subjects[], scores[], passFail[], count를 private으로 선언
	 * count는 배열의  index로 사용
	 *  numberStudents를 정적 필드로 선언
	 */
	
	private String name;
	private int age;
	private String[] subjects;
	private int[] scores;
	private int[] passFail;
	private int count;
	
	static int numberStudents;
	
	// 생성자
	/*name, age, subjects[], scores[], passFail[], count를 매개변수로 전달받는 생성자 정의
	 * 
	 */

	Student3(String name, int age, String[] subjects, int[] scores, int[] passFail, int count) {
		this.name=name;
		this.age=age;
		this.subjects=subjects;
		this.scores=scores;
		this.passFail=passFail;
		this.count=count;
	}
	
	// setter 메소드: setName(String name), setAge(int age),  setSubjects(String subjects[]), setScores(int scores[]), setCount(int num)
	
	
	// 학생 수를 반환하는 정적 메소드getNumberStudents()
	
	static int getNumberStudents() {
		return numberStudents;
	}

	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudent() {
		/*
		 * 이름 = **, 나이 = **
		 * 과목1 = **, 점수1 = **
		 * 과목2 = **, 점수2 = **
		 * ... 등으로 출력
		 */
	}

	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudentInfo() {
		/*
		 * 이름 = **, 나이 = **
		 * 과목1 = **, 점수1 = **, 통과여부=pass
		 * 과목2 = **, 점수2 = **, 통과여부=fail
		 * ... 등으로 출력
		 */
	}

	// 통과 여부 (모든 과목을 통과했는지 확인)
	public void isPassed(int i) {
		//주어진 학생이 모든 과목 통여 여부를 반환 
			if (scores[i] > passFail[i]) {
				System.out.println("pass");
			}
			else {System.out.println("fail");}
	}

	// 6.2.2 각 학생의 성적 테이블을 출력하는 정적 메소드
	public static void printAllStudents(Student3[] students) {
		//학생 이름 + 과목명, 과목 점수 .... + 과목통과여부:pass or fail
		for (Student3 st : students) {
			System.out.println("name=" + st.name + "	age=" + st.age);
			for (int i = 1; i <= st.subjects.length; i++) {
				System.out.print("subject" + i + "=" + st.subjects[i - 1] + "	score=" + st.scores[i - 1] + "	pass=");
				st.isPassed(i - 1);
			}
		}
	}

	// 6.2.2 과목별 최대/최소 점수 및 해당 학생을 출력하는 정적 메소드
	public static void printSubjectStats(Student3[] students) {
		
		String[] subj = {"수학", "국어", "영어", "과학", "역사"};
		String[] maxName = {"","","","",""};
		String[] minName = {"","","","",""};
		
		for (int i = 0; i < 5; i++) {
			
			int[] max = {0,0,0,0,0}; 
			max[i] = students[0].scores[i];
			
			
			int[] min = {0,0,0,0,0};
			min[i] = students[0].scores[i];
			
			
			for (Student3 st : students) {
				if (st.scores[i] > max[i]) {
					max[i] = st.scores[i];
					maxName[i] = st.name;
				}
				if (st.scores[i] < min[i]) {
					min[i] = st.scores[i];
					minName[i] = st.name;
				}
			}
		System.out.println(subj[i]);
		System.out.print(max[i]+"\t"+maxName[i]+"\n");
		System.out.print(min[i]+"\t"+minName[i]+"\n");
		}
	}
}
public class 실습6_3정적메소드 {
	
	
	public static void main(String[] args) {
		
		String[] subjects = {"수학", "국어", "영어", "과학", "역사"};
		int [] passFails = {40,70,90,55,90};
		Student3[] students = { new Student3("홍길동", 21, subjects, new int[]{85, 90, 78, 88, 92},passFails, -1),
								new Student3("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, passFails,-1),
								new Student3("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, passFails,-1),
								new Student3("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, passFails,-1),
								new Student3("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, passFails,-1)
				/*
				 *  생성자를 사용하여 객체 생성
				 *  ("홍길동", 21, subjects, new int[]{85, 90, 78, 88, 92},passFails, -1),
				 *  ("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, passFails,-1),
				 *  ("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, passFails,-1),
				 *  ("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, passFails,-1),
				 *  ("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, passFails,-1)
				 */
		};
		// 학생 수를 정적 메소드 호출로 처리

		// 학생 정보 출력 (예시)
		//showStudents(students);

		// 각 학생의 성적 테이블 출력
		Student3.printAllStudents(students);

		// 과목별 최대/최소 점수 및 해당 학생 출력
		Student3.printSubjectStats(students);
	}
}


