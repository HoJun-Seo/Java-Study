package Inheritance;

public class CreditLineAccount extends Account{
	int creditLine;
	CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}
	int withdraw(int amount) throws Exception{ //메소드 오버라이딩 - 슈퍼클래스의 withdraw method 를 무시하고 똑같은 이름의 withdraw method를 다시 구현한다.
		//메소드 오버라이딩은 같은 시그니처를 갖는 메소드에 대해서만 일어난다.
		if((balance + creditLine) < amount)
			throw new Exception("인출이 불가능합니다.");
		balance -= amount;
		return amount;
	}
}
