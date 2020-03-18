package MultiThread;

public class PrintThread2 extends Thread{
	SharedArea2 sharedArea;
	PrintThread2(SharedArea2 area){
		sharedArea = area;
	}
	public void run() {
		for(int cnt = 0; cnt < 3; cnt++) {
			synchronized (sharedArea) { //동기화 블록
				int sum = sharedArea.account1.balance + sharedArea.account2.balance;
				//critical section : 소스 코드 상에서는 하나의 명령문 이지만, 컴파일이 되고 나면 sharedArea.account1.balance 필드값을 가져오는 일과
				//sharedArea.account2.balance 필드 값을 가져오는 일을 별도로 처리하기 때문에 그 중간에 다른 스레드로 제어가 넘어가면 문제가 될 수 있다.
				System.out.println("계좌 잔액 합계 : " + sum);
			}
			try {
				Thread.sleep(1);
			}
			catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
