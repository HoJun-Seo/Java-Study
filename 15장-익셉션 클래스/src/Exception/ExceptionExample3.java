package Exception;
/*
 * 자바 컴파일러는 메소드 밖으로 던지는 익셉션도 checked exception 인지 unchecked exception 인지에 따라 다르게 체크한다.
 * 해당 프로그램은 checked exception 을, ExceptionExample4 는 unchecked exception 을 메소드 밖으로 던지고 있다.
 * 이 두 메소드에는 모두 throws 절에 없지만, 해당 프로그램은 컴파일 에러를 발생하고, ExceptionExample4 프로그램은 발생하지 않는다.
 * 해당 프로그램과 같은 컴파일 에러가 발생하지 않게 하려면 add method 에 throws 절을 추가해야 한다.
 */
public class ExceptionExample3 {
	public static void main(String[] args) {
		try {
			int result = add(1, -2);
			System.out.println(result);
		}
		catch(Exception e) {
			System.out.println("에러 발생");
		}
	}
	static int add(int a, int b) throws Exception {
		int result = a + b;
		if(result < 0) throw new Exception("에러 발생");
		return result;
	}
}
