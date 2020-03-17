package MultiThread;
//java.lang.Runnable interface 를 사용하는 방식
public class SmallLetters implements Runnable{
	public void run() {
		for(char ch = 'a'; ch <= 'z'; ch++)
			System.out.println(ch);
	}
}
