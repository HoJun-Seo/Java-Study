package Generic;

import lombok.Getter;
import lombok.Setter;

public class Generic {
	public static void main(String[] args) {
		
		Human<String> hu = new Human<>();
		hu.setName("서호준");
		hu.setPhone("010-5062-3007");
		System.out.println(hu.toString());
		
		Physical<Number> ph = new Physical<>();
		//ph.setAge("26"); 문자열 데이터를 입력하려고 하면 오류가 발생한다.
		ph.setAge(26);
		ph.setHeight(167.5);
		ph.setWeight(57);
		System.out.println(ph.toString());
	}
}

@Getter
@Setter
class Human<T extends String>{
	private String name;
	private String phone;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름 : " + name + ", 연락처 : " + phone;
	}
}

@Getter
@Setter
class Physical<T extends Number>{
	private int age;
	private double height;
	private double weight;
	
	@Override
	public String toString() {
		return "나이 : " + age + ", 키 : " + height + ", 몸무게 : " + weight;
	}
}


