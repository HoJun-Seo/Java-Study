package Inheritance;

public class InterfaceExample3 {
	public static void main(String[] args) throws Exception {
		SeperateVolume obj = new SeperateVolume("863ㅂ", "나무", "베르베르");
		printState(obj);
		obj.checkOut("이수경", "20060317");
		printState(obj);
	}
	static void printState(SeperateVolume obj) {
		if(obj.state == Lendable.STATE_NORMAL) { //Lendable interface 의 상수 필드 사용
												//해당 인터페이스를 구현하지 않는 클래스에서 인터페이스의 상수 필드를 사용하려면
												//필드 이름 앞에 인터페이스 이름과 마침표(.)를 써주면 된다.
			System.out.println("------------------");
			System.out.println("대출 상태 : 대툴 가능");
			System.out.println("------------------");
		}
		if(obj.state == Lendable.STATE_BORROWED) {
			System.out.println("------------------");
			System.out.println("대출상태 : 대출중");
			System.out.println("대출인 : " + obj.borrower);
			System.out.println("대출일 : " + obj.checkOutDate);
			System.out.println("------------------");
		}
	}
}
