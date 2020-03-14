package Nested;

public class NestedClassExample3 {
	public static void main(String[] args) {
		PiggyBank bank1 = new PiggyBank();
		PiggyBank bank2 = new PiggyBank();
		PiggyBank bank3 = new PiggyBank();
		//세 개의 돼지 저금통 객체를 생성한다.
		bank2.slot.put(100); // 두번째 돼지 저금통의 입구로 100원을 넣는다.
		System.out.println("첫번째 돼지 저금통 : " + bank1.total);
		System.out.println("두번째 돼지 저금통 : " + bank2.total);
		System.out.println("세번째 돼지 저금통 : " + bank3.total);
		//세 개의 돼지 저금통에 있는 액수를 출력한다.
	}
}
