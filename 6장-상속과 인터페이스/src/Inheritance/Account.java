package Inheritance;

public class Account {
	//class 앞에 public 이 아닌 abstract 를 붙일 시 Account class 를 더 이상 인스턴스화 시킬 수 없게 된다.(추상 클래스 - abstract class)
	//class 앞에 public 이 아닌 final 을 붙일 시 다른 class 에서 Account class 를 상속 받을 수 없게 된다.
	String accountNo;
	String ownerName;
	int balance;
	Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	void deposit(int amount) {
		balance += amount;
	}
	int withdraw(int amount) throws Exception {
		//메소드 선언문 맨 앞에 final 키워드를 붙여줄 경우 Account class 를 상속 받는 다른 class 에서 해당 method 를 오버라이딩 할 수 없게 된다. 
		if(balance < amount)
			throw new Exception("잔액이 부족합니다.");
		balance -= amount;
		return amount;
	}
}
