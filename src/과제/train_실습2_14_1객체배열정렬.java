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
	
	@Override //이름순으로 정렬
	public int compareTo(PhyscData2 o) {
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
	/*9-19-2025 강의중 sort 메소드 직접 구현. 클래스에서 정의된 compareTo 메소드에 맞춰서 엔트리를 스왑.
	private static void swap(PhyscData2[] data, int i, int j) {
		PhyscData2 temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}*/
	
	//키순으로 정렬
	private static void sortData(PhyscData2[] data) {
		Arrays.sort(data, new Comparator<PhyscData2>() {
			@Override
			public int compare(PhyscData2 d1, PhyscData2 d2) {
				Double x=d1.getHeight();
				Double y=d2.getHeight();
				return x.compareTo(y);
			}	
		}); 
		/*9-18-2025 데이터 타입에 따른 .sort 메소드 사용법
		data가 List가 아니라 Array라서 .sort 메서드가 안되는 듯함. 
		Array는 Array.sort(Array array, new Comparator<T>(){comparator 오버라이드 구현}) 방법으로 사용
		List는 list (List 객체) list.sort(new Comparator<T>(){comparator 오버라이드 구현}).*/
		
		/*9-19-2025 강의중 sort 메소드 직접 구현. 클래스에서 정의된 compareTo 메소드에 맞춰서 엔트리를 스왑.
		for (int i =0; i< data.length; i++) {
			for (int j=i+1; j<data.length; j++) {
				if (data[i].compareTo(data[j]) > 0)
					swap(data,i,j);
			}
		}*/
		
	}
	
	private static int binarySearch(PhyscData2[] data, String string) {
		if(data==null || string.isEmpty()) return -1; // 방어코드
		
		//ㅁㅁㅁ직접 binarySearch를 구현해볼 수 있도록 하자
		int left = 0;
		int right = data.length - 1;
		int center = (left+right)/2;
		
		int x = string.compareTo(data[center].getName()); //디버깅용
		
		do {
			if (string.compareTo(data[center].getName()) > 0) {
				left = center;
				center = (left+right)/2;
				x = string.compareTo(data[center].getName());
			}
			else if (string.compareTo(data[center].getName()) < 0) {
			 	right = center;
			 	center = (left+right)/2;
			 	x = string.compareTo(data[center].getName());
			}
			
			else {return center;}
			
			if (left == center) break; //무한루프 방지. 무한루프는 quotient가 floor값을 리턴하는 특성상 left == center의 경우에만 발생
		} while (left < right);
		
		return -1;	//탐색실패했을 경우
		
		/* ㅁㅁㅁ이미 라이브러리에 구현되어있는 binarySearch를 이용해보기
		PhyscData2 theMan = new PhyscData2();
		
		for (PhyscData2 man:data) {
			if (man.getName() == string) {
				theMan = man;
			}
		}
		return Arrays.binarySearch(data,theMan);*/
	}
	
	private static PhyscData2[] insertObject(PhyscData2[] data, PhyscData2 newData) {
		if(data==null || newData==null) return null; //방어코드
		
		PhyscData2[] insertObject = new PhyscData2[data.length + 1];
		
		int left = 0;
		int right = data.length - 1;
		int center = (left+right)/2;
		
		int x = newData.compareTo(data[center]); //디버깅용
		
		do {
			if (newData.compareTo(data[center]) > 0) {
				left = center;
				center = (left+right)/2;
				x = newData.compareTo(data[center]);
			}
			else if (newData.compareTo(data[center]) < 0) {
			 	right = center;
			 	center = (left+right)/2;
			 	x = newData.compareTo(data[center]);
			}
			
			else {break;}
			
			if (left == center) break; //무한루프 방지 무한루프는 quotient가 floor값을 리턴하는 특성상 left == center의 경우에만 발생
		} while (left < right);//do-while
		
		if(newData.compareTo(data[left]) > 0 ) {
			insertObject[++center]=newData;//left == center인데 left 다음칸에 삽입해야할 경우 	
		}
		else {
			insertObject[center] = newData;//insert
		}
		
		for (int i=0; i<center; i++) {
			insertObject[i] = data[i]; 
		}//for i
		
		for (int i=center; i<data.length; i++) {
			insertObject[i+1] = data[i];
		}//for i

		return insertObject;
	}//insertObject()
	
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
		PhyscData2[] newData2= insertObject(data, new PhyscData2("홍", 179, 1.5));
		//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		showData("삽입후", newData);
		showData("삽입후", newData2);
	}


}
