package MultiThread;
/*
 * 프로그램의 실행 흐름 - 스레드(Thread)
 * 싱글 스레드 프로그램의 경우(single thread program)의 경우 main method 의 첫번째 명령문 부터 시작되고, main method의 마지막에 도달하거나
 * return 문을 만나면 끝난다.
 * 그런데 온라인 강좌 프로그램이나 인터넷 전화 프로그램 등 둘 이상의 실행흐름을 갖도록 만들어야 하는 프로그램의 경우 멀티 스레드(Multi-thread) 방식으로 프로그램을 작성한다.
 * 멀티 스레드 프로그램은 싱글 스레드 프로그램과 마찬가지로 main method 의 첫번째 명령문(메인 스레드)부터 실행이 된다.(메인 스레드는 프로그램이 시작되면 자동으로 시작된다.)
 * 메인 스레드 외에 다른 스레드는 메인 스레드 상에서 만들어진 이후 시작된다. 이후 해당 스레드가 실행되고 나면 메인 스레드와 동등한 레벨이 되기 때문에 
 * 메인 스레드가 끝나더라도 다른 스레드는 끝나지 않고 실행을 계속 할 수 있다.
 * 따라서 멀티 스레드 프로그램에서는 메인 스레드가 끝났다고 해서 프로그램이 끝나는 것이 아니라, 그 프로그램을 구성하는 모든 스레드가 끝이 나야만 끝나게 된다.
 * 멀티 스레드 프로그램을 작성하기 위해서는 세 가지를 할 줄 알아야 한다. 1. 스레드 생성, 2. 스레드 시작, 3. 스레드가 할 일 기술
 * 이런 일들은 두 가지 방법으로 할 수 있다. 그 중 하나는 jdk 라이브러리의 java.lang.Thread class 를 이용하는 방법이고 다른 하나는 java.lang.Runnable interface 를 이용하는 방법이다.
 *  
 */
public class MultiThreadExample1 {
	public static void main(String[] args) {
		Thread thread = new DigitThread(); //스레드를 생성하는 식
		/*
		 * 스레드는 개념적으로는 프로그램의 실행 흐름을 의미 하지만, 자바에서 말하는 스레드의 실체는 스레드 클래스의 객체이다.
		 * 그러니까 스레드 클래스인 DigitThread class 의 객체를 생성하는 것으로 스레드를 만들 수 있다.
		 * 스레드 객체는 슈퍼 클래스인 Thread 타입의 변수에 대입하는 것이 보통이나, 꼭 이렇게 해야 한다는 규칙이 있는건 아니기 때문에 
		 * DigitThread 타입의 변수에 대입해도 상관없다.
		 */
		thread.start();//스레드를 시작하는 메소드
		/*
		 * java.lang.Thread class 안에는 start method 가 있는데, 이 메소드는 스레드를 시작하는 메소드 이다.
		 * 이 메소드는 다른 모든 스레드 클래스에 상속되기 때문에 모든 스레드 객체레 대해 호출 할 수 있다.
		 * 이 메소드는 스레드를 시작하기 위해 필요한 여러가지 준비 작업을 한 후에 스레드 클래스의 run method 를 호출하여 스레드의 실행을 시작한다.
		 */
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
/*
 * java.lang.Thread class 를 이용하여 멀티 스레드 프로그램을 작성하는 법
 * A - Z 까지 출력 -> 메인 스레드, 0 - 9 까지 출력 -> 멀티 스레드
 * 스레드가 하는 일은 각각 별도의 클래스에 기술해야 한다, 그러니 이 프로그램을 작성하기 위해서는 총 2개의 클래스가 필요하다.
 * 메인 스레드가 아닌 스레드로 실행할 클래스를 선언할 때는 jdk 라이브러리에 있는 java.lang.Thread class 의 서브 클래스로 선언하거나, java.lang.Runnable interface 를 구현하는 클래스로 선언해야 한다.
 */
