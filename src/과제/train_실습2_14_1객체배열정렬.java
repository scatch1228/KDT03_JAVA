package 과제;
/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;
import java.util.Comparator;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
	
	public PhyscData2() {
		super();
	}
	
	
	public PhyscData2(String name, int height, double vision) {
		super();
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	@Override
	public int compareTo(PhyscData2 o) {
		//이름순으로
		return name.compareTo(o.name);
	}
	
	public double getHeight() {
		return height;
	}

	public String getName() {
		return name;
	}

	public double getVision() {
		return vision;
	}
	
	public String toString() {
		return "name: "+name+", height: "+height+", vision: "+vision;
	}


}
public class train_실습2_14_1객체배열정렬 {

	private static void showData(String msg, PhyscData2[] data) {
		System.out.println(msg);
		for(PhyscData2 info : data) {
		System.out.println(info.toString());
		}
		
	}
	//키순으로 정렬
	private static void sortData(PhyscData2[] data) {
		Arrays.sort(data, new Comparator<PhyscData2>() {
			@Override
			public int compare(PhyscData2 d1, PhyscData2 d2) {
				Double x=d1.getHeight();
				Double y=d2.getHeight();
				return x.compareTo(y);
			}	
		}); //data가 List가 아니라 Array라서 .sort 메서드가 안되는 듯함. 9-18-2025
		//Array는 Array.sort(Array array, new Comparator<T>(){comparator 오버라이드 구현}) 방법으로 사용
		//List는 list (List 객체) list.sort(new Comparator<T>(){comparator 오버라이드 구현}).  
		
	}
	
	private static int binarySearch(PhyscData2[] data, String string) {
		if(data==null || string.isEmpty()) return -1;
		
		/*int dataLength = data.length/2;
		
		for (int index =0; index < dataLength; index++) {
			
		}*/
		
		PhyscData2 theMan = new PhyscData2();
		for (PhyscData2 man:data) {
			if (man.getName() == string) {
				theMan = man;
			}
		}
		
		return Arrays.binarySearch(data,theMan);
		
		//직접 binarySearch를 구현해볼 수 있도록 하자
	}
	
	private static PhyscData2[] insertObject(PhyscData2[] data, PhyscData2 newData) {
		if(data==null || newData==null) return null;
		
		return null;
	}
	
	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍동", 164, 1.3),
				new PhyscData2("홍길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2),
				new PhyscData2("최길동", 169, 0.5),
		};
		showData("정렬전",data);
		sortData(data);//키순으로 정렬된다.\
		showData("키순으로 정렬후", data);

		Arrays.sort(data);//comparator가 필요하다 
		showData("Arrays.sort(이름순) 실행후", data);//이름순으로 정렬된다.
		
		int resultIndex = binarySearch(data, "이길동");
		if (resultIndex >= 0)
			System.out.println("사이다가 존재하면 인덱스 = "+resultIndex);
		else
			System.out.println("사이다가 존재하지 않는다");
		
		PhyscData2[] newData= insertObject(data, new PhyscData2("소주다", 179, 1.5));
		//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);
	}


}
