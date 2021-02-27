package innerclass;


public class OutClass { // 외부 클래스
	
	private int num = 10; //외부 클래스 private 변수
	private static int sNum = 20; // 외부 클래스 정적 변수
	
	private InClass inClass; // 내부 클래스 자료형 변수를 먼저 선언
	
	// 외부 클래스 생성자 호출 시 내부 클래스 또한 함께 생성자 호출하여 객체 생성
	public OutClass() {
		// 외부 클래스 디폴트 생성자, 
		// 외부 클래스가 생성된 후에 내부 클래스 생성 가능
		inClass = new InClass();
	}
	
	class InClass { // 인스턴스 내부 클래스
		int inNum = 100; // 내부 클래스의 인스턴스 변수
		/*
		 * 인스턴스 내부 클래스에 정적 변수 선언 불가능
		 * 오류가 발생하므로 주석 처리함
		 */
		//static int sInNum = 200; 
		
		void inTest() {
			System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
			System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수)");
		}
		/*
		static void sTest() {
			정적 메소드 역시 정의 불가능
			오류가 발생하므로 주석 처리함
		} */
	}
	public void usingClass() {
		inClass.inTest();
	}
}

