package basic;

public class FinalExample1 {
	public static void main(String[] args) {
		final double pi = 3.14; //final 변수 사용 - 값의 변경이 불가능하다.
		double radius = 2.0, circum;
		circum = 2 * pi * radius;
		System.out.println(circum);
	}
}
