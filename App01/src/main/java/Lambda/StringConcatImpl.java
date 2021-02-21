package Lambda;

import LambdaInterface.StringConcat;

// 람다식을 활용하지 않을 경우 인터페이스에 선언된 메소드의 구현부를
// 따로 작성해줄 클래스를 만들어야 한다.
public class StringConcatImpl implements StringConcat{
	
	// 함수형 인터페이스 내부에 선언된 메소드의 구현부
	@Override
	public void makeString(String s1, String s2) {
		System.out.println(s1 + ", " + s2);
		
	}
}
