package Nested;

public class NestedClassExample8 {
	public static void main(String[] args) {
		class SatelliteSender extends MessageSender{ //MessageSender class 를 상속받는 로컬 이너 클래스
			//MessageSender class 는 EMailSender class, SMSSender class 뿐만 아니라 다른 모든 메시지 송신에 사용되는 클래스들의 
			//슈퍼 클래스로 사용하기 위해 만든 클래스이다. 따라서 새로운 매체를 통해 메시지를 송신하는 클래스가 필요할 때는
			//이 클래스의 서브 클래스로 만들어야 한다.
			//만약 이런 클래스가 지속적으로 필요한 게 아니라 특정 프로그램의 특정 메소드 안에서만 필요하다면 해당 프로그램과 같이
			//그 메소드의 본체 안에 선언할 수 있다.
			void send(String message) {
				System.out.println("발신 : 마이다스");
				System.out.println("수신 : 빌 게이츠");
				System.out.println("메시지 : " + message);
				System.out.println();
			}
		}
		//로컬 이너 클래스는 메소드 밖에 있는 다른 클래스를 상속받는 서브 클래스로 선언할 수도 있다.
		SatelliteSender obj = new SatelliteSender();//로컬 이너 클래스의 객체 생성
		obj.send("굿 모닝"); //로컬 이너 클래스의 메소드 호출
	}
	/*
	 * 그런데 해당 프로그램 처럼 로컬 이너 클래스를 선언하는 목적이 슈퍼 클래스의 메소드를 오버라이드 하기 위한 것이고
	 * 서브 클래스의 객체를 딱 하나만 생성할 필요가 있는 경우라면, 다음과 같이 더 간단한 방법으로 프로그램을 작성할 수 있다.
	 * class SatelliteSender extends MessageSender{ 
			void send(String message) {
				System.out.println("발신 : 마이다스");
				System.out.println("수신 : 빌 게이츠");
				System.out.println("메시지 : " + message);
				System.out.println();
			}
		}
		SatelliteSender obj = new SatelliteSender();
		
		변경 -> MessageSender obj = new MessageSender() { - 슈퍼 클래스 타입으로 변수를 선언하고, 슈퍼 클래스의 생성자를 호출한다.
				void send(String message) {
				System.out.println("발신 : 마이다스");
				System.out.println("수신 : 빌 게이츠");
				System.out.println("메시지 : " + message);
				System.out.println();
				- 클래스 본체는 그대로 내버려둔다.
			}
		}; <- 마지막에 세미콜론을 써준다.
		obj.send("굿 모닝");
		
		아래쪽에 작성한 로컬 이너 클래스는 이름이 없기 때문에 이름 없는 이너 클래스(anonymous inner class) 라고 부른다.
	 */
}
