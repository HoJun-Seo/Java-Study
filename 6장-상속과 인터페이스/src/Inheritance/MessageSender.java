package Inheritance;

abstract class MessageSender {
	String title;
	String senderName;
	MessageSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
	}
	abstract void sendMessage(String recipient); //추상 메소드 선언
	/*
	 * 추상 메소드 선언 : 메소드의 본체가 없음 - 매체의 종류마다 완전히 다른 로직의 메소드를 작성해야 할 경우
	 * 추상 메소드를 포함하는 클래스는, 클래스 자체도 추상 클래스로 선언해야 한다.
	 * 본체가 없기 때문에 서브 클래스에 상속해줄 로직도 없고, MessageSender 객체를 만들 수도 없다.
	 * 그렇다면 추상 메소드를 선언하는 목적은 뭘까?
	 * 1. 서브 클래스에서 이 메소드를 반드시 구현하도록 만들기 위함(서브 클래스에서 지켜야 할 규칙이 공식적으로 만들어진다.)
	 * 2. 다형성 : 하나의 변수에 여러 종류의 데이터를 대입 할 수 있는 성질
	 */
}
