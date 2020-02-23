package object_class;

public class PhysicalInfo {
	String name;
	int age;
	float height, weight;
	PhysicalInfo(String name, int age, float height, float weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	void update(int age) {
		this.age = age;
	}
	void update(int age, float height) {
		this.age = age;
		this.height = height;
	}
	void update(int age, float height, float weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	//한 클래스 내에 똑같은 이름의 메소드를 여러개 선언 할 수 있다 - 메소드 오버로딩
}
