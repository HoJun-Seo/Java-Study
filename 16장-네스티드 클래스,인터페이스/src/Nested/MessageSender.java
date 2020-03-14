package Nested;
//NestedClassExample8 의 로컬 이너 클래스에게 상속되는 클래스
//EMailSender, SMSSender 에게도 상속된다.
public abstract class MessageSender {
	abstract void send(String message);
}
