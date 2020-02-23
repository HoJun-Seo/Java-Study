package Inheritance;

public class CheckingAccount extends Account{//Account class 를 extends 키워드를 통하여 상속 받는다.
	String cardNo;
	CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance); //super class 에 생성자가 있기 때문에 super 키워드를 이용하여 해당 super class 의 생성자를 호출해 온다.
		this.cardNo = cardNo;
	}	
	int pay(String cardNo, int amount) throws Exception{ //인위적 익셉션 처리
		if(!cardNo.equals(this.cardNo) || (balance < amount))
			throw new Exception("지불이 불가능합니다."); //인위적 익셉션 처리
		return withdraw(amount); //Account class 의 withdraw method 를 호출하여 받은 return 값을 return 한다.
	}
}
