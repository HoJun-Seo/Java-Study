package Nested;
//인터페이스를 구현하는 로컬 이너 클래스를 선언할 때도 이름 없는 이너 클래스로 선언할 수 있다.
public class NestedClassExample10 {
	public static void main(String[] args) {
		Player obj = new Player() {
			public void play(String source) {
				System.out.println("플레이 시작 : " + source);
			}
			public void stop() {
				System.out.println("플레이 종료");
			}
		};
		//Player interface 를 구현하는 이름 없는 이너 클래스
		obj.play("LetItBe.mp3");
		obj.stop();
		//이름 없는 이너 클래스의 메소드 호출
	}
}
