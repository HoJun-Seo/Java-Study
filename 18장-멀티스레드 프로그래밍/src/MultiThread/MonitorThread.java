package MultiThread;
/*
 * 스레드의 상태
 * 멀팃 스레드 프로그램에서의 스레드 스케쥴링은 자바 가상 기계에 의해 임의로 이루어지기 때문에, 프로그램의 로직만 보고 스레드의 실행 순서를 예측 할 수는 없다.
 * 하지만 프로그램 실행 도중에 스레드의 상태를 알아낼 수 있는 방법은 있다.
 * 스레드의 라이프 사이클 : 멀티 스레드 프로그램의 스레드는 라이프 사이클을 갖는다.
 * 스레드 객체를 만들면 스레드가 생성되고, 그 스레드 객체에 대해 start method 를 호출하면 run method 로 진입하여 실행이 시작된다.
 * run method 를 완료하고 나면 그 스레드는 죽은 상태가 되는데, 죽은 스레드는 다시 사용할 수 없기 때문에 이것으로 스레드의 라이프 사이클은 끝이 난다.
 * 이 라이프 사이클에 따르면 스레드의 상태는 run method 진입 전, run method 진입, run method 완료 라는 3가지 상태로 구분 할 수 있다.
 * 이중 run method 진입 상태는 다시 두 가지로 구분된다.
 * 자바 가상 기계는 프로그램의 실행 시간을 작은 시간 간격으로 나누어서 스레드를 번갈아 실행한다. 그런데 어떤 스레드는 자기 차례가 돌아와도
 * 실행 될 수 없는 상태에 있다. wait method, sleep method 를 호출 중인 스레드가 그렇다.
 * 그런 스레드는 다른 스레드로부터 신호가 오거나, 일정 시간이 경과해야만 실행을 계속 할 수 있다.
 * 이렇게 자기 차례가 돌아와도 실행 될 수 없는 스레드의 상태를 Not Runnable 상태라고 하고, 실행중이거나 자기 차례만 돌아오면 바로 실행 될수 있는 상태를 Runnable 상태라고 한다.
 * 실행되기 전 상태(New Thread) -> (실행 가능상태(Runnable), 실행 불가능 상태(Not Runnable)) -> 실행을 끝낸 상태(Dead Thread)  
 */
public class MonitorThread extends Thread{
	Thread thread;
	MonitorThread(Thread thread) {
		this.thread = thread;
	}
	public void run() {
		//모니터링 대상 스레드의 상태를 2초마다 한번씩 출력한다.
		while(true) {
			Thread.State state = thread.getState();
			System.out.println("스레드의 상태 : " + state);
			if(state == Thread.State.TERMINATED)
				break; //스레드가 종료 되었을 경우 break
			try {
				Thread.sleep(2000); //2초간 기다렸다가 스레드 실행
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
/*
 * 스레드의 상태를 나타내는 메소드
 * 스레드 클래스의 최상위 슈퍼클래스인 java.lang.Thread class 에는 스레드의 현재 상태를 알아내는 getState 라는 메소드가 있다.
 * 에 메소드의 호출 방법은 다음과 같다. -> Thread.State state = thread.getState(); - thread : 스레드 객체, getState() : 스레드이 현재 상태를 리턴하는 메소드
 * 여기서 사용된 Thread.State 라는 타입은 Thread class 안에 선언되어 있는 State 열거 타입을 말한다.
 * 이 열거 타입 스레드의 상태를 표현하는데, 이 타입에 속하는 열거값들은 아래와 같다.
 * NEW : 실행되기 전 상태, RUNNABLE : 실행 가능 상태, WAITING : wait method 를 호출하고 있는 상태, TIMED_WAITING : sleep method 를 호출하고 있는 상태
 * BLOCKED : 다른 스레드의 동기화 블록이나 동기화 메소드가 끝나기를 기다리고 있는 상태, TERMINATED : 실행을 마친 상태
 * 위에 있는 열거 값들 중 NEW, RUNNABLE, TERMINATED 는 각각 New Thread, Runnable, Dead Thread 상태에 해당한다.
 * 나머지 세 개의 열거값은 모두 Not Runnable 상태에 해당한다.
 */
