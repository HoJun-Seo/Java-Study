package Exception;
//unchecked exception 인 ArithmeticException 이 발생한다.
public class ExceptionExample2 {
	public static void main(String[] args) {
		int num1 = 3, num2 = 0;
		int result = num1 / num2;
		System.out.println(result);
	}
}
