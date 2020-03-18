package MultiThread;

public class PrintThread extends Thread{
	SharedArea sharedArea;
	public void run() {
		while(sharedArea.isReady != true) //공유 데이터 유무 체크
			continue;
		//SharedArea 객체의 isReady 필드 값이 true 가 될 때까지 루프를 반복한다.
		//while 문으로 isReady 필드 값을 쉴 새 없이 반복 체크하는 것은 비효율적이다.
		//여기서는 앞에서 사용했던 Thread.sleep method 를 이용하여 필드 값을 체크하는 시간 간격을 벌려줌으로서 cpu 의 부담을 덜어 줄 수 있을뿐 아니라
		//메소드를 호출하는 즉시 실행 흐름의 제어가 다른 스레드로 넘어가기 때문에 isReady 필드 값이 바뀔 가능성도 생기게 된다.
		//하지만 그 보다 더 좋은 방법은 CalcThread 가 공유 영역에 데이터를 쓰고 나서 PrintThread 로 직접 신호를 보내는 것이다.
		System.out.println(sharedArea.result);//공유 영역의 데이터를 출력한다.
	}
}
