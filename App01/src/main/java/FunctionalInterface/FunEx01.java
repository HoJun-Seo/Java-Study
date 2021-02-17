package FunctionalInterface;

public class FunEx01 {
	public static void main(String[] args) {
		BiTest test = (a,b) -> a + "와 " + b + "가 매개변수로 넘어 왔습니다.";
		
		String a = "유튜브";
		String b = "네이버";
		System.out.println(test.apply(a, b));
	}
}
/*
 * 반환 자료형이 String 이고, 인자가 2개인 BiTest 인터페이스를 작성
 * apply(String a, String b)추상 메소드를 작성하여 활용하는 프로그램을 작성)
 */

@FunctionalInterface
interface BiTest{
	abstract String apply(String a, String b);
}

