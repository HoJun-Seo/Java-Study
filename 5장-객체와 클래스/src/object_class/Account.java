package object_class;

public class Account {
	String accountNo;
	String ownerName;
	int balance;
	Account(String accountNo, String ownerName, int balance){
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	void deposit(int amount) {
		balance += amount;
	}
	int withdraw(int amount) throws Exception {
		if(balance < amount) 
			throw new Exception("잔액이 부족합니다."); //잔액이 요구금액 보다 적을 시 익셉션을 발생시킨다.
		balance -= amount;
		return amount;
	}
}
