package innerclass;

public class InnerStaticTest {
	public static void main(String[] args) {
		// 외부 클래스를 생성하지 않고 바로 정적 내부 클래스 생성 가능
		OuterClassStatic.InStaticClass inStaticClass = 
				new OuterClassStatic.InStaticClass();
		System.out.println("정적 내부 클래스 일반 메소드 호출");
		inStaticClass.inTest();
		System.out.println();
		System.out.println("정적 내부 클래스의 정적 메소드 호출");
		inStaticClass.sTest();
		// 정적 내부 클래스의 정적 메소드의 경우 객체를 생성할 필요 없이(내부 클래스를 생성할 필요 없이) 곧바로 사용 가능하다.
		// 반면 일반 메소드는 객체 생성(내부 클래스 생성) 없이 호출할 수 없다.
		OuterClassStatic.InStaticClass.sTest();
	}
}
