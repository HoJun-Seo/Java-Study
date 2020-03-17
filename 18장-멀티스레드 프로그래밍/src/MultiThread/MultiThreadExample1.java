package MultiThread;

public class MultiThreadExample1 {
	public static void main(String[] args) {
		Thread thread = new DigitThread();
		thread.start();
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);
		}
	}
}
