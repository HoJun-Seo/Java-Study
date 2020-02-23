package object_class;

public class MethodExample1 {
	public static void main(String[] args) {
		printCharacter('*', 30);
		System.out.println("Hello, Java");
		printCharacter('-', 30);
		/*Account obj1 = new Account("111-222-33333333", "김영식", 200000);
		Account obj2 = new Account("555-666-77777777", "박진희", 1000000);
		obj1.deposit(1000000);
		try {
			obj2.withdraw(1200000); //익셉션이 발생되는 메소드
		}
		catch(Exception e) {
			String msg = e.getMessage();
			System.out.println(msg);
		}
		//printAccount(obj1);
		//printAccount(obj2);
	*/}
	static void printCharacter(char ch, int num) {
		for(int cnt = 0; cnt < num; cnt++)
			System.out.print(ch);
		System.out.println();
	}
	//static void printAccount(Account obj) {
		//System.out.println("계좌번호 : " + obj.accountNo);
		//System.out.println("예금주 이름 : " + obj.ownerName);
		//System.out.println("잔액 : " + obj.balance);
		//System.out.println();
	//}
}
