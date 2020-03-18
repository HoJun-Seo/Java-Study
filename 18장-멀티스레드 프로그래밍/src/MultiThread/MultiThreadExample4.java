package MultiThread;
/*
 * 스레드 간의 커뮤니케이션 - 멀티 스레드 프로그램의 스레드 들이 경우에 따라 서로 데이터를 교환해야 할 경우
 * 가장 기본적이고 일반적인 방법은 두 스레드가 공동으로 접근 가능한 메모리 영역을 만들어두고, 한 쪽 스레드는 거기에 데이터를 쓰고 다른 스레드는 거기에 있는
 * 데이터를 읽어 가는 것이다.데이터 교환에 사용되는 영역은 레퍼런스 타입으로 만들어야 한다., 그래야 두 스레드가 각각 가지고 있는 참조값을 이용해서
 * 같은 공유 영역을 가리킬 수 있기 때문이다.
 */
public class MultiThreadExample4 {
	public static void main(String[] args) {
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		//공유 영역 객체를 생성해서 그 객체의 참조값을 두 스레드의 필드에 저장한다.
		thread1.start();
		thread2.start();
	}
}
