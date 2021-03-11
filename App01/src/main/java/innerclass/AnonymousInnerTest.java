package innerclass;

public class AnonymousInnerTest {
	public static void main(String[] args) {
		OuterClassAnony out = new OuterClassAnony();
		/*Runnable 인터페이스 자료형으로 변수를 선언하고, 인터페이스의 익명 내부 클래스가 */
		Runnable runnable = out.getRunnable(10);
		runnable.run(); // 메소드 반환 형태의 익명 내부 클래스 수행
		out.runner.run(); // 변수 반환 형태의 익명 내부 클래스 수행
	}
}
