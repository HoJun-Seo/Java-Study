package MultiThread;
/*
 * Runnable interface 를 이용한 멀티 스레드 프로그램(java.lang.Runnable interface)
 * java.lang.Runnable interface 를 이용하여 멀티 스레드 프로그램을 작성 할 때는, 별도의 스레드로 작동시킬 클래스를
 * java.lang.Runnable interface 를 구현하는 클래스로 선언해야 한다.(implements)
 * 이 클래스 안에는 스레드가 해야 할 일을 써 넣어야 하는데, 그런 명령문은 java.lang.Thread class 를 상속하는 클래스의 경우와 마찬가지로 run method 안에 넣어야 한다.
 * Runnable interface 를 사용하는 클래스는 Thread class 를 상속받는 클래스의 경우와는 다르게,
 * 스레드를 만들 때 해당 클래스의 객체를 생성한 다음에 그 객체를 생성자 파라미터로 삼아서 Thread 객체를 생성해야 한다.
 * 생성된 Thread 객체는 스레드가 된다. 객체를 가지고 스레드를 시작하는 방법은 앞에서 배운 방법과 동일하게 start method 를 호출한다.
 */
public class MultiThreadExample3 {
	public static void main(String[] args) {
		Thread thread = new Thread(new SmallLetters()); //Runnable interface 를 구현하는 클래스의 객체를 생성해서 Thread 생성자의 파라미터로 사용한다.
		thread.start();
		char arr[] = {'ㄱ', 'ㄴ', 'ㄷ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅅ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
		for(char ch : arr)
			System.out.println(ch);
	}
}
