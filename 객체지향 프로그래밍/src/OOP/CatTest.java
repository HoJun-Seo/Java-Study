package OOP;

public class CatTest {
	public static void main(String[] args) {
		
		Cat c = new Cat();
		
		// 객체의 필드값 변경하기
		c.name = "야옹이";
		c.breeds = "페르시안";
		c.age = 3;
				
		System.out.println("이름 : " + c.name);
		System.out.println("품종 : " + c.breeds);
		System.out.println("나이 : " + c.age);
		
		// 객체에 특정 동작을 수행시키는 것을 인스턴스 메소드 호출이라고 한다
		c.claw();
		c.meow();
	}
}

class Cat{
	String name;
	String breeds;
	int age;
	
	void claw() {
		System.out.println("할퀴기");
	}
	
	void meow() {
		System.out.println("야옹");
	}
}
