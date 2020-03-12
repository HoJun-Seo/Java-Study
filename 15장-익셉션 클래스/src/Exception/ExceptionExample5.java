package Exception;
/*
 * 익셉션 클래스는 상속 관계를 갖기 때문에 모든 익셉션 객체에 대해 공통된 메소드를 호출할 수 있다.
 * 그리고 여러 타입의 익셉션을 하나로 처리할 수 있다.
 * 익셉션 클래스의 공통 슈퍼클래스인 Throwable class 에는 몇몇 메소드 들이 선언되어 있는데, 그 메소드들은 모든 서브 클래스에 상속 되기 때문에
 * 모든 종류의 익셉션 객체에 대해 호출 할 수 있다.
 * getMessage method 는 에러 메시지를 가져오는 메소드이다.
 * 해당 메소드는 익셉션 객체가 가지고 있는 에러 메시지를 리턴하는 메소드이며, 이 메소드는 아래와 같은 방버으로 호출 할 수 있다.
 * String str = e.getMessage(); - 익셉션 객체에 있는 에러 메시지를 리턴하는 메소드
 */
public class ExceptionExample5 {
	public static void main(String[] args) {
		int num1 = 2, num2 = 0;
		try {
			int result = num1 / num2;
			System.out.println(result);
		}
		catch(ArithmeticException e) {
			String str = e.getMessage();
			System.out.println(str);
			/*
			 * by zero 라는 에러 메시지는 정수를 0 으로 나누는 익셉션이 발생 할때 JVM 이 ArithmethicException 에 자동으로 설정하는 에러 메시지이다.
			 */ 
		}
	}
}
