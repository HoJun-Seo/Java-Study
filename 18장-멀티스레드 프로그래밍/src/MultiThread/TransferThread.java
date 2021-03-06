package MultiThread;

public class TransferThread extends Thread{
	SharedArea2 sharedArea;
	TransferThread(SharedArea2 area){
		sharedArea = area;
	}
	public void run() {
		for(int cnt = 0; cnt < 12; cnt++) {
			sharedArea.transfer(100); //계좌 이체 메소드 호출 - SharedArea2 class 안에 동기화 메소드가 선언되어 있을 경우
			/*synchronized (sharedArea) { //동기화 블록
				sharedArea.account1.withdraw(1000000);
				System.out.println("이몽룡 계좌 : 100만원 인출");
				sharedArea.account2.deposit(1000000);
				System.out.println("성춘향 계좌 : 100만원 입금");
				//critical section - 이몽룡의 계좌에서 인출된 100만원이 성춘향의 계좌로 입금되기 전에 PrintThread 로 실행의 제어가 넘어간다.
			}*/ //SharedArea2 class 안에 동기화 메소드가 선언되어 있지 않을 경우
		}
	}
}
