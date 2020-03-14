package Nested;

public class PiggyBank { //돼지 저금통 클래스
	int total; 
	Slot slot;
	PiggyBank(){
		total = 0;
		slot = new Slot();
	}
	class Slot{ //입구 클래스
		void put(int amount) {
			total += amount; //인클로징 클래스의 필드를 직접 사용한다. - 인클로징 클래스 와의 연관 관계
		}
	}
}
