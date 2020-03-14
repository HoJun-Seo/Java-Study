package Nested;
/*
 * 클래스나 인터페이스 안에 선언된 인터페이스를 네스티드 인터페이스 라고 한다.
 * 네스티드 인터페이스는 네스티드 클래스 처럼 여러 종류로 나뉘지 않고 정적 네스티드 인터페이스 한 종류만 존재한다.
 * 네스티드 인터페이스는 static 키워드를 붙이지 않아도 컴파일 할때 자동으로 붙기 때문에 정적 네스티드 인터페이스로 취급된다.
 */
public class MP3PlayerFactory extends PlayerFactory{ //PlayerFactory class 상속
	public Player createPlayer() {
		return new MP3Player();
	}
	//상속받은 네스티드 인터페이스를 구현하는 네스티드 클래스
	class MP3Player implements Player{
		public void play(String source) {
			System.out.println("플레이 시작 : " + source);
		}
		public void stop() {
			System.out.println("플레이 종료");
		}
	}
}
