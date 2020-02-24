package Inheritance;

public class InheritanceExample6 { //추상 메소드를 상속받아 오버라이드 한 메소드를 사용하는 class
	public static void main(String[] args) {
		EmailSender obj1 = new EmailSender("생일을 축하합니다.", "고객센터", "admin@dukeeshop.co.kr", "10% 할인쿠폰이 발행되었습니다.");
		SMSSender obj2 = new SMSSender("생일을 축하합니다.", "고객센터", "02-000-0000", "10% 할인쿠폰이 발행되었습니다.");
		send(obj1 ,"hatman@yeyeye.com");
		send(obj1 ,"stickman@hahaha.com");
		send(obj2 ,"010-000-0000");
	}
	static void send(MessageSender obj, String recipient) {
		obj.sendMessage(recipient); //클래스의 다형성, MessageSender type 변수에 EmailSender type 변수 또는,
									//SMSSender type 변수를 대입 시켜도 대입 시킨 변수의 type 은 변하지 않는다.
									//(즉, MessageSender type 변수로 type 이 변경되지 않음)
	}
}
