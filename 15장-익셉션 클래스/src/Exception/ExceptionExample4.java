package Exception;

public class ExceptionExample4 {
	public static void main(String[] args) {
		try {
			int result = divide(3, 0);
			System.out.println(result);
		}
		catch(ArithmeticException e) {
			System.out.println("에러 발생");
		}
	}
	static int divide(int a, int b) {
		int result = a / b;
		return result;
	}
}
