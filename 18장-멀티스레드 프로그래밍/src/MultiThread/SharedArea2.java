package MultiThread;
/*
 * 동기화 메소드
 * 앞에서 작성했던 계좌 이체를 하는 부분과 잔액 합계를 나타내는 부분은 SharedArea2 class 의 account1, account2 필드와 밀접한 관련이 있기 때문에
 * 아래와 같이 SharedArea2 class 안에 메소드로 선언할 수 있다. 
 */
public class SharedArea2 {
	Account account1;
	Account account2;
	synchronized void transfer(int amount) { //계좌 이체를 한다.
		 //메소드 안에 있는 명령문 전체가 동기화 블록이고, 그 동기화 블록이 this 객체에 대한 것일 경우에는 메소드 자체를 동기화 하는 방법을 사용할 수도 있다.
		//메소드 선언 타입 앞에 synchronized 키워들 붙여주는 것으로 구현 가능하다.
		account1.withdraw(1000000);
		System.out.println("이몽룡 계좌 : 100만원 인출");
		account2.deposit(1000000);
		System.out.println("성춘향 계좌 : 100만원 입금");
		/*synchronized (this) {
			account1.withdraw(1000000);
			System.out.println("이몽룡 계좌 : 100만원 인출");
			account2.deposit(1000000);
			System.out.println("성춘향 계좌 : 100만원 입금");
		}*/
	}
	synchronized int getTotal() { //잔액 합계를 구한다.
		return account1.balance + account2.balance;
		/*synchronized (this) {
			return account1.balance + account2.balance;
		}*/
	}
}
