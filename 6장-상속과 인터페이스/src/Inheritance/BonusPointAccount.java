package Inheritance;

public class BonusPointAccount extends Account{
	int bonusPoint;
	BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}
	void deposit(int amount) { 
		super.deposit(amount); //단순한 기능 확장을 구현 하는 것이므로 메소드 오버라이딩을 할 필요 없이
		//super class 의 deposit method 를 호출해준다.
		bonusPoint += (int)(amount * 0.001);
	}
}
