package Reference;

public class RefTypeExample10 {
	public static void main(String[] args) {
		Account obj = new Account("111-22-33333333", "홍길동", 100000);
		if(obj instanceof CheckingAccount) //캐스트 가능성을 검사하는 instanceof 연산자 활용(가능하면 true, 그렇지 않으면 false)
			pay((CheckingAccount)obj); //obj 를 CheckingAccount 로 캐스트 할 수 있을때만 pay method 호출
		else
			System.out.println("캐스트 할 수 없는 타입 입니다.");
	}
	static void pay(CheckingAccount obj) {
		try {
			int amount = obj.pay("5555-6666-7777-8888", 47000);
			System.out.println("인출액 : " + amount);
			System.out.println("카드 번호 : " + obj.cardNo);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
