package Lambda;

import LambdaInterface.StringConcat;

public class TestStringConcat {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "World";
		// 함수형 인터페이스를 객체지향 방식으로 구현한 경우
		// 함수형 인터페이스를 구현하고 있는 클래스 객체를 만든 선언한 후 메소드를 호출한다.
		StringConcatImpl concat1 = new StringConcatImpl();
		concat1.makeString(s1, s2);
		
		// 함수형 인터페이스를 람다식으로 구현한 경우
		// 클래스를 따로 생성할 필요 없이 바로 메소드를 구현해서 사용할 수 있다.
		StringConcat concat2 = (s,v) -> System.out.println(s + ", " + v);
		concat2.makeString(s1, s2);
	}
}
