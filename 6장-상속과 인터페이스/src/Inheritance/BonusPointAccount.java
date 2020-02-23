package Inheritance;

public class BonusPointAccount extends Account{
	int bonusPoint;
	BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}
	void deposit(int amount) { //메소드 오버라이딩 - Account class 의 deposit method 무시
		super.deposit(amount);
		bonusPoint += (int)(amount * 0.001);
	}
}
