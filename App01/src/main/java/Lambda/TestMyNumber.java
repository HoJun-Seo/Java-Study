package Lambda;

import LambdaInterface.MyNumber;

public class TestMyNumber {
	public static void main(String[] args) {
		// 람다식을 인터페이스형 max 변수에 대입
		MyNumber max = (x,y) -> (x >= y) ? x : y;
		// 인터페이스형 변수로 메소드 호출  
		System.out.println(max.getMax(10, 20));
	}
}
