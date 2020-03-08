package Wrapper;
/*
 * 자바 프로그램에서는 래퍼 객체가 쓰여야 할 자리에 프리미티브 타입의 값이 사용되면 그 값을 갖는 래퍼 객체가 자동으로 생성되어 대신 사용된다.
 */
public class WrapperExample5 {
	public static void main(String[] args) {
		printDouble(new Double(123.45));
		printDouble(123.45);
	}
	static void printDouble(Double obj) { //double 타입의 값을 가지고 Double 타입의 파라미터를 받는 메소드를 호출한다.(8행)
		System.out.println(obj);
	}
}
