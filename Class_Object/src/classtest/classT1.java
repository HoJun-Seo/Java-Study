package classtest;

public class classT1 {
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
// 객체지향(기반) 프로그램 구조
// 캡슐화(정보은닉)
// 상속(기능공유 : 기능확장)
// 추상화, 다형성(하나의 메세지를 여러기능을 가진 형태로) -> 100+200(산술연산), "100" + "홍길동" -> 연결

// 클래스 = 변수(기억장소) + 메소드 : 기능
// 클래스를 설계(작성) 한다는 말은 사용자가 직접 작성하는 기억장소 및 함수 타입을 만드는 것