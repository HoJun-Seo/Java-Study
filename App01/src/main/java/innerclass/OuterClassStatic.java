package innerclass;

public class OuterClassStatic {
	private int num = 10;
	private static int sNum = 10;
	
	static class InStaticClass{ // 정적 내부 클래스
		int inNum = 100; 
		static int sInNum = 200; // 정적 내부 클래스의 정적 변수
		
		void inTest() {
			System.out.println("InStaticClass inNum = " + inNum + 
					"(내부 클래스의 인스턴스 변수 사용)");
			System.out.println("InStaticClass sInNum = " + sInNum + 
					"(내부 클래스의 정적 변수 사용)");
			System.out.println("OutClass sNum = " + sNum + 
					"(외부 클래스의 정적 변수 사용)");
		}
		
		static void sTest() {
			 /*
			  * num += 10; 
			  * inNum += 10;
			  * 외부 클래스와 내부 클래스의 인스턴스 변수는 사용할 수 없으므로 주석 처리
			  * (외부 클래스의 생성과 상관없이 메소드가 실행되기 때문에 외부 클래스의 인스턴스 변수 사용 불가)
			  * (외부 클래스가 생성되지 않은 채 실행되면, 내부 클래스의 인스턴스 변수가 생성되지 않기 때문에 내부 클래스의 인스턴스 변수 또한 사용불가 )
			  */
			System.out.println("OutClass sNum = " + sNum + 
					 "(외부 클래스의 정적 변수 사용)");
			System.out.println("InStaticClass sInNum = " + sInNum + 
					"(내부 클래스의 정적 변수 사용)");
		}
	}
}
