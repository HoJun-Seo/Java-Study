package Nested;

public abstract class PlayerFactory {
	abstract Player createPlayer();
	interface Player{
		void play(String source);
		void stop();
	}
	//네스티드 인터페이스 선언
}
