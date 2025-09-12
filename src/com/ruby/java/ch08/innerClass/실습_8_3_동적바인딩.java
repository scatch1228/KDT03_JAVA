package com.ruby.java.ch08.innerClass;

//동적바인딩
//Item 추상 클래스
abstract class Item {
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량

	// 생성자
	public Item(String name, double price, int stockQuantity) {
		super();
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	// Getter	
	public int getStockQuantity() {
		return stockQuantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "name = " + name + ", price = " + price + ", stockQuantity = " + stockQuantity;
	}
	
	

	// 재고 감소 메소드
	public void reduceStock(int quantity) {
		stockQuantity -= quantity;
	}

	public abstract void show();
}

//Electronics 클래스: Item 클래스 상속
class Electronics extends Item {
	int madeYear;

	// 생성자
	public Electronics(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear = madeYear;
	}
	
	@Override
	public void show() {
		System.out.println("Electronics : " + super.toString() + ", madeYear = " + madeYear);
	}

	
}

//Clothing 클래스: Item 클래스 상속
class Clothing extends Item {
	int size;

	// 생성자
	public Clothing(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}
	
	
	@Override
	public void show() {
		System.out.println("Clothing : " + super.toString() + ", size = " + size);
	}

	
}

//Discountable 인터페이스 정의
interface Discountable {
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double seasonalDiscount;

	// 생성자
	public SeasonalDiscount() {
		seasonalDiscount = 0.0;
	}
	
	public SeasonalDiscount(double seasonalDiscount) {
		this.seasonalDiscount = seasonalDiscount;
	}
	
	@Override
	public double getDiscountedPrice(double price) {
		return price * seasonalDiscount;
	}
}

//Order 클래스
class Order extends SeasonalDiscount {
	private final int N = 20;
	private Customer customer; // 고객명
	private Item[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String[] orderDates; // 주문일자들
	private int count = 0;

	// 생성자
	public Order(Customer customer, double seasonalDiscount) {
		super(seasonalDiscount);
		this.customer = customer;
		items = new Item[2];
		quantities = new int[2];
		orderDates = new String[2];
	}
	
	public void addItem(Item item, int quantity, String date) {
		// 최대 주문 item 개수를 넘어서는지 확인
		if (quantity > item.getStockQuantity()) {
			System.out.println("not enough, 제품(" + item.getName() + ")을 담지 않습니다.");
			this.items[count] = item;
			this.quantities[count] = 0;
			this.orderDates[count] = "N/A";
			count++;
		}
		// item에 재고가 있는지 확인
		else {
			System.out.println("enough, 제품(" + item.getName() + ")이 주문됩니다.");
			
			// 재고가 있으면 아이템 추가
			this.items[count] = item;
			this.quantities[count] = quantity;
			this.orderDates[count] = date;
			count++;
			
			//재고량 감소
			item.reduceStock(quantity);
		}
	}

	private double calculateTotal() {
		/*
		 * 할인없이 수량 단가로 비용 계산
		 */
		double x = 0;
		for (int i=0; i<count; i++) {
			x += quantities[i]*items[i].getPrice() ;
		}//for i
		
		return x;
	}

	private double calculateDiscount(double price) {
		/*
		 * 할인을 적용한 비용 계산
		 * 2 types of getDiscountedPrice: 1 for customer class, 1 for order class imported from seasonal discount interface. 
		 * apply this for each item
		 */
		
		return price-customer.getDiscountedPrice(price)-getDiscountedPrice(price);
	}
	
	// 주문 내역을 출력하는 메소드
	public void printOrderSummary() {
		System.out.println("고객정보 : "+ customer.getName());
		
		for (int i=0; i<count; i++) {
			System.out.println("제품명 : " +items[i].getName()+ ", 단가 : " +items[i].getPrice()
								+ ", 개수 : " + quantities[i] + " ==> 가격 : " +items[i].getPrice()*quantities[i]
								+ ", 주문일 : " + orderDates[i]);
		}
		
		System.out.println("총액 : " +calculateTotal());
	}

	// 할인된 내역을 출력하는 메소드
	public void printDiscountDetails() {
		/*
		 * 할인가격 = 정가 - (정가*시즌할인율) - (정가*고객할인율)
		 */
		for (int i=0; i<count; i++) {
			System.out.println("제품명 : " +items[i].getName()+ ", 할인 : " + calculateDiscount(items[i].getPrice()) 
								+ ", 개수 : " + quantities[i] + " ==> 가격 : " +calculateDiscount(items[i].getPrice())*quantities[i]
								+ ", 주문일 : " + orderDates[i]);
		}//for i
		
		System.out.println("총액 : " +  Math.round(calculateDiscount( calculateTotal() ) * 100.0) /100.0 );
	}
}

//Customer 추상 클래스 정의
abstract class Customer {
	private String name;

	// 생성자
	public Customer(String name) {
		this.name = name;
	}
	
	// Getter
	public String getName() {
		return name;
	}

	abstract double getDiscountedPrice(double price);

	
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer {
	static final double REGULARDISCOUNT_RATE = 0.03;

	// 생성자
	public RegularCustomer(String name) {
		super(name);
	}
	
	@Override
	double getDiscountedPrice(double price) {
		return price * REGULARDISCOUNT_RATE;
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	// 생성자
	public PremiumCustomer(String name) {
		super(name);
	}

	@Override
	double getDiscountedPrice(double price) {
		return price * PREMIUMDISCOUNT_RATE;
	}

	
}
public class 실습_8_3_동적바인딩 {
	static void showItemsStock(Item[] items) {
		// 모든 아이템의 이름과 재고량, 가격 출력
		for (Item item : items) {
			item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
		}
	}

	public static void main(String[] args) {
		// Item 타입의 배열 생성
				Item[] items = new Item[4];
				
				// 배열에 전자제품과 의류패션 객체 추가
				items[0] = new Electronics("노트북", 150, 100, 23);
				items[1] = new Clothing("티셔츠", 10, 100, 95);
				items[2] = new Electronics("휴대폰", 80, 100, 24);
				items[3] = new Clothing("청바지", 20, 100, 90);
				
				// 모든 아이템의 이름과 재고량, 가격 출력
				System.out.println(">>모든 아이템의 이름과 재고량, 가격 출력");
				showItemsStock(items);
				System.out.println("-".repeat(80));
				
				// 고객 생성
				Customer regularCustomer = new RegularCustomer("홍길동");
				Customer premiumCustomer = new PremiumCustomer("강감찬");
				
				// 주문 생성 및 계산 (RegularCustomer)
				Order regularOrder = new Order(regularCustomer, 0.01);
				regularOrder.addItem(items[0], 120, "240901");
				regularOrder.addItem(items[1], 2, "240902");
				
				System.out.println(">>RegularCustomer 주문 내역 출력");
				regularOrder.printOrderSummary();

				System.out.println(">>RegularCustomer 할인된 주문 내역 출력");
				regularOrder.printDiscountDetails(); // 할인된 내역 출력
				System.out.println("-".repeat(80));
				
				// 주문 생성 및 계산 (PremiumCustomer)
				Order premiumOrder = new Order(premiumCustomer, 0.01);
				premiumOrder.addItem(items[1], 1, "240901");
				premiumOrder.addItem(items[3], 2, "240903");

				System.out.println(">>PremiumCustomer 주문 내역 출력");
				premiumOrder.printOrderSummary();
				
				System.out.println(">>PremiumCustomer 할인된 주문 내역 출력");
				premiumOrder.printDiscountDetails(); // 할인된 내역 출
				System.out.println("-".repeat(80));
				
				// 모든 아이템의 이름과 재고량, 가격 출력
				System.out.println(">>모든 아이템의 이름과 재고량, 가격 출력");
				showItemsStock(items);
	}
}

