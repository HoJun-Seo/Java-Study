package OOP;

public class Main {
	public static void main(String[] args) {
		
		Dog d = new Dog();
		
		System.out.println("이름 : " + d.name);
		System.out.println("품종 : " + d.breeds);
		System.out.println("나이 : " + d.age);
	}
}

// Dog 클래스
class Dog {
	
	String name; // 이름 
	String breeds; // 품종
	int age; // 체중
	
	void wag() {
		System.out.println("꼬리 치기");
	}
	
	void bark() {
		System.out.println("짖기");
	}
}