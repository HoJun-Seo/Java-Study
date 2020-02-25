package Inheritance;

interface Lendable {// 인터페이스 - 서브 클래스들의 공통점을 추출해서 정의된다.(공통 데이터는 불가, 기능, 즉 공통 메소드만 정의 가능)
					//슈퍼 클래스의 다중 상속을 허용하지 않는 대신 인터페이스를 활용한다.
	final static byte STATE_BORROWED = 1; //대출 중 - 인터페이스 상수 선언
	final static byte STATE_NORMAL = 0; //대출되지 않은 상태 - 인터페이스 상수 선언
	abstract void checkOut(String aborrower, String data) throws Exception; //인터페이스에 속하는 메소드는 무조건 추상 메소드로 선언해야 한다.
	abstract void checkIn();
}
