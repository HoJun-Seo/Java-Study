package OOP;

public class BicycleTest {
	public static void main(String[] args) {
		
		Bicycle b1 = new Bicycle();
		
		b1.name = "로드형 자전거";
		b1.weight = 7.25;
		b1.price = 326000;
		
		Bicycle b2 = new Bicycle();
		
		b2.name = "산악형 자전거";
		b2.weight = 10.68;
		b2.price = 429000;
		
		// 객체 정보 출력
		System.out.println(b1.name + " " + b1.weight + " " + b1.price);
		System.out.println(b2.name + " " + b2.weight + " " + b2.price);
		
		// 생성자를 통한 객체 초기화
		Bicycle b3 = new Bicycle("경주용 자전거", 15.78, 678000);
		System.out.println(b3.name + " " + b3.weight + " " + b3.price);
	}
}

class Bicycle{
	String name;
	double weight;
	int price;
	
	public Bicycle() {
	}
	
	public Bicycle(String name, double weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	void move() {
		System.out.println("자전거를 타고 이동한다.");
	}
	
	void horn() {
		System.out.println("따르르릉");
	}
}
