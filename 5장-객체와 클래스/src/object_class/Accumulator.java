package object_class;

public class Accumulator {
	int total = 0; //각 개체마다 따로 생성가능
	static int grandTotal = 0; //정적 필드를 선언하는 선언문 - 클래스 자체에 속하는 데이터를 저장할 변수(특정 객체 상관없이 클래스 자체에 하나만 생기는 정적필드)
	void accumulate(int amount) {
		total += amount;
		grandTotal += amount; //정적 필드를 사용하는 명령문
	}
	static int getGrandTotal() { //정적 메소드 선언
		return grandTotal;
	}
}
