package MultiThread;
/*
 * java.lang.Thread class 를 상속받는 클래스
 * 자바에서는 java.lang.Thread class 와 이 클래스의 서브 클래스를 스레드 클래스(thread class) 라고 한다.
 * 스레드 클래스 안에는 스레드가 해야 할 일을 명령문으로 써넣어야 한다. 그리고 그런 명령문은 run 이라는 이름의 method 안에 써넣어야 한다.
 * run method 는 public, void method 로 선언해야 한다, 그렇지 않으면 스레드가 시작되어도 이 메소드가 실행되지 않는다.
 */
public class DigitThread extends Thread{ //java.lang.Thread 의 서브 클래스로 선언
	public void run() {
		for(int cnt = 0; cnt < 10; cnt++) {
			System.out.println(cnt);
			//스레드가 해야 할 일을 run method 안에 작성
			try {
				Thread.sleep(1000);
				/*
				 * java.lang.Thread class 에는 sleep method 가 있는데, 이 메소드는 아무 일도 하지 않고 주어진 시간이 경과되기를 기다리는 메소드이다.
				 * 이 메소드는 정적 메소드(static method) 이기 때문에 위와 같은 방법으로 호출 할 수 있다.
				 * 이 메소드에 넘겨지는 파라미터는 밀리세컨드 단위로 취급되기 때문에, 이 메소드에 1000 이라는 값을 넘겨주면 1초가 경과할 동안 아무 일도 하지 않고 기다렸다가 리턴한다.
				 * 그런데 이 메소드는 checked Exception 인 InterruptedException 을 발생 할 수 있기 때문에 try - catch 문으로 묶어서 처리해야 한다. 
				 */
			}
			catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
/*
 * 멀티 스레드 프로그램은 여러개의 스레드를 갖는 프로그램이지만, 실제로 그런 스레드가 동시에 실행되는 것은 아니다.
 * 자바 가상 기계는 멀티 스레드 프로그램을 실행할 때 프로그램의 실행 시간을 아주 작은 간격으로 나누어서 스레드들을 번갈아 실행할 뿐이다.
 * 자바 가상 기계가 스레드에 할당하는 시간과 실행 순서는 하드웨어의 성능이나 시스템 환경에 따라 달라질 수 있다.
 * 그래서 어떤 경우에는 알파벳이 모두 출력되고 나서 숫자가 출력되거나, 그 반대의 일이 일어날 수도 있다.
 * 하지만 그렇게 되면 멀티 스레드 프로그램을 실행해보는 의의가 없어진다.
 * 그럴때는 알파벳과 숫자가 출력되는 시간 간격을 늘리면 되는데, 그런 일은 sleep method 를 이용할 수 있다.
 */
