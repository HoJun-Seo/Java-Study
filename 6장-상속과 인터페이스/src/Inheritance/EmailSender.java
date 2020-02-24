package Inheritance;
//추상 클래스로 선언되어 추상 메소드를 포함하고 있는 MessageSender class 를 상속받는 이메일 송신 클래스
public class EmailSender extends MessageSender{
	String senderAddr;
	String emailBody;
	EmailSender(String title, String senderName, String senderAddr, String emailBody) {
		super(title, senderName);
		this.senderAddr = senderAddr;
		this.emailBody = emailBody;
	}
	void sendMessage(String recipient) { //슈퍼 클래스의 메소드를 오버라이드 하는 메소드
		System.out.println("-----------------------------");
		System.out.println("제목 : " + title);
		System.out.println("보내는 사람 : " + senderName + " " + senderAddr);
		System.out.println("받는 사람 : " + recipient);
		System.out.println("내용 : " + emailBody);
	}
}
