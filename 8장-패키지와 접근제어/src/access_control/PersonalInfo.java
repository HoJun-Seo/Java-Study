package access_control;
//private 생성자를 만들어서 같은 클래스 내에서 호출하는 경우
public class PersonalInfo {
	String name;
	int age;
	char gender;
	String bloodType;
	private PersonalInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}
	PersonalInfo(String name, int age, char gender){
		this(name, age);
		this.gender = gender;
	}
	PersonalInfo(String name, int age, char gender, String bloodType){
		this(name, age);
		this.gender = gender;
		this.bloodType = bloodType;
	}
}
