package Nested;
/*
 * 이너 클래스 객체와 인클로징 객체 간의 연관 관계는 이너 클래스 객체가 생성될 때 정해지며, 그 관계는 이너 클래스의 객체가 소멸될 때 까지 바뀌지 않는다.
 * 그렇기 때문에 bank1 객체와 bank2 객체의 slot 필드 값을 서로 바꿔도, 그 필드를 통해 넣은 돈이 원래 연관을 맺고 있는 PiggyBank 객체에 누적된다.
 */
public class NestedClassExample4 {
	public static void main(String[] args) {
		PiggyBank bank1 = new PiggyBank();
		PiggyBank bank2 = new PiggyBank();
		//두 개의 돼지 저금통 객체를 생성한다.
		PiggyBank.Slot temp = bank1.slot;
		bank1.slot = bank2.slot;
		bank2.slot = temp;
		//돼지 저금통의 입구를 뒤바꾼다.
		bank1.slot.put(10000);
		bank2.slot.put(10);
		//돼지 저금통에 서로 다른 금액을 넣는다.
		System.out.println("첫번째 돼지 저금통 : " + bank1.total);
		System.out.println("두번째 돼지 저금통 : " + bank2.total);
	}
}
