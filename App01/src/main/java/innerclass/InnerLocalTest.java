package innerclass;

public class InnerLocalTest {
	public static void main(String[] args) {
		OuterClassLocal outerClassLocal = new OuterClassLocal();
		Runnable runner = outerClassLocal.getRunnable(10); // 메소드 호출
		runner.run(); 
	}
}
