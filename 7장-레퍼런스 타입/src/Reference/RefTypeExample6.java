package Reference;

public class RefTypeExample6 {
	public static void main(String[] args) {
		Account obj = new CheckingAccount("111-22-33333333", "홍길동", 10, "4444-5555-6666-7777");
		try {
			int amount = obj.pay("4444-5555-6666-7777", 47000); //Accoutn class 에 없는 메소드는 사용할 수 없다.
			System.out.println("인출액 : " + amount);
			System.out.println("카드 번호 : " + obj.cardNo);//Accoutn class 에 없는 필드는 사용할 수 없다.
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
