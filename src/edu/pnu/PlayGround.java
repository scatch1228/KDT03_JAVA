package edu.pnu;

enum Mandarin {
	금귤(600), 한라봉(500), 레드향(300), 천혜향(400), 황금향(800);//Mandarin 클래스의 객체들
/*
 *     // enum 상수 → 정적(static) 상수(final 객체) > 싱글턴/singleton 객체라 한다 
    public static final Mandarin 금귤 = new Mandarin("금귤", 0, 600);
    public static final Mandarin 한라봉 = new Mandarin("한라봉", 1, 500);
    public static final Mandarin 레드향 = new Mandarin("레드향", 2, 300);

 */
	
	private int price;
	//enum의 생성자: enum 상수마다 생성자를 호출하여 초기화한다 - enum 객체가 처음 만들어질 때 호출된다
	/*
	 * enum의 각 상수(예: 금귤, 한라봉 등)는 static final 객체처럼 동작
	 * enum이 처음 로드될 때, 내부적으로 모든 enum 상수가 인스턴스로 생성
	 * 클래스가 로드되면 enum 내부의 상수(즉, 금귤, 한라봉, 레드향, 천혜향, 황금향)들이 한 번만 생성자(Mandarin(int p))를 호출하여 초기화
	 */
	Mandarin(int p) {
		price = p;
		System.out.println("enum 생성자 실행:: price = " + price);
	}

	int getPrice() {
		return price;
	}
	
	static Mandarin MandarinAt(int idx) {
		for (Mandarin m : Mandarin.values())
			if (m.ordinal() == idx)
				return m;
		return null;
	}
}

public class PlayGround {
	
	public static void main(String[] args) {
		Mandarin m[] = Mandarin.values();
		
	}

}
