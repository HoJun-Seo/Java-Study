package Wrapper;
/*
 * 프리미티브 타입의 값을 래퍼 객체로 만드는 것을 박싱(Boxing) 이라고 하고, 레퍼 객체를 프리미티브 타입의 값으로 만드는 것을 언박싱(Unboxing) 이라고 한다.
 * 앞서 배웠던 것과 같이 박싱은 래퍼 클래스의 생성자를 이용해서 할 수 있고, 언박싱은 Value method 를 이용해서 할 수 있다.
 * Integer obj = new Integer(12000); - Boxing, int num = obj.intValue(); - Unboxing
 * 그런데 자바 프로그램에서는 많은 경우에 박싱과 언박싱이 자동으로 일어난다.
 * 자바 프로그램 에서는 프리미티브 타입의 값을 써야 할 자리에 래퍼 객체를 사용하면, 그 래퍼 객체로부터 프리미티브 타입의 값이
 * 자동으로 추출되어 대신 사용된다.
 */
public class WrapperExample4 {
	public static void main(String[] args) {
		Integer obj = new Integer("10"); //문자열 형태로 정수 값을 넘김
		int sum = obj + 20; //Interger 객체와 int 타입의 값을 더하는 명령문
		//Integer 객체에서 자동으로 프리미티브 타입의 값이 추출되어 연산에 이용됨.
		System.out.println(sum);
	}
}
