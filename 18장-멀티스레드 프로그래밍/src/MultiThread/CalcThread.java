package MultiThread;

public class CalcThread extends Thread{
	SharedArea sharedArea;
	public void run() {
		double total = 0.0;
		for(int cnt = 1; cnt < 1000000000; cnt += 2)
			if(cnt / 2 % 2 == 0)
				total += 1.0 / cnt;
			else
				total -= 1.0 / cnt;
		//파이를 계산하는 부분
		sharedArea.result = total * 4; //계산 결과를 공유 영역에 쓴다.
		sharedArea.isReady = true; //SharedArea 객체의 isReady 필드 값을 true 로 설정한다.
		//CalcThread 가 공유 영역에 데이터를 쓰고 난 다음에 이 필드의 값을 true 로 설정하면, PrintThread 는 그 값을 가지고 
		//공유 데이터의 유무를 체크 할 수 있다.
	}
}
