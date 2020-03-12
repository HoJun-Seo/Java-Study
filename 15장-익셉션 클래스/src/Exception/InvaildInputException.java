package Exception;
/*
 * 익셉션 클래스의 선언 방법
 * 우리가 응용 프로그램에서 사용할 익셉션 클래스는 checked Exception 으로 만드는 것이 가장 무난다.
 * checked Exception 을 선언할 때는 RuntimeException class 를 거치지 않고 Exception class 를 상속 받아서 선언해야 한다.
 * 익셉션 클래스에는 필요하지 않다면 필드나 메소드는 선언하지 않아도 좋으나, 생성자 만큼은 에러 메시지를 설정하기 위해 꼭 필요하므로 선언해 두는 것이 좋다.
 * 예를 들어 입력 데이터가 잘못 들어왔을때 발생하는 익셉션의 클래스는 해당 프로그램과 같이 선언할 수 있다.
 */
public class InvaildInputException extends Exception{ //Exception class 의 서브 클래스로 선언한다.
	InvaildInputException() {
		super("잘못된 입력입니다.");
		//슈퍼 클래스의 생성자를 호출하여 에러 메시지를 저장한다.
	}
}
