package Exception;
/*
 * 익셉션 객체와 익셉션 클래스
 * 자바 프로그램에서 익셉션은 객체로 표현된다.(익셉션 객체 - Exception object)
 * 익셉션은 객체로 만들어지기 때문에, 그 익셉션을 잡는 catch 절에서도 그 객체를 대입할 수 있는 변수로 잡아야 한다.
 * 모든 객체가 다 익셉션이 될 수 있는 것은 아니며, 자바 에서는 익셉션을 만들수 있는 클래스를 다른 클래스와 구분하여 익셉션 클래스(Exception class) 라고 한다.
 * jdk 라이브러리의 java.lang 패키지 에는 Throwable 이라는 클래스가 있는데, 이 클래스의 서브 클래스만이 익셉션 클래스가 될 수 있다.
 * Throwable class 를 직접 상속하는 서브 클래스는 Exception class 와 Error class 둘 뿐이다.
 * Exception class : 
 * 		IOException :
 * 			FileNotFoundException
 * 		RuntimeException :
 * 			ArithmeticException, NullPointerException
 * Error class : 
 * 		VirtualMachineError :
 * 			OutOfMemoryError, InternalError
 * 		LinkeageError :
 * 			ClassFormatError
 * Exception class 와 그 서브클래스 들은 비교적 덜 심각한 익셉션을 표현한다, 그리고 Error class 와 그 서브클래스들은 상대적으로 심각한 익셉션을 표현한다.
 * 에러는 발생위치를 파악하기도 어렵고 복구하기도 어렵기 때문에 사실상 try - catch 문으로 처리가 불가능하나, 그 밖의 익셉션들은 모두 처리할 수 있다.
 *  
 */
public class ExceptionExample1 {
	public static void main(String[] args) {
		int sum = 1 + -2;
		if(sum < 0)
			throw new Exception("에러발생");
		//throw 문 : 익셉션 객체를 생성하는 식이 포함되어 있다.
		//throw 문으로 던진 익셉션은 Exception 타입의 변수를 이용하여 잡을 수 있다. - catch(Exception e)
		System.out.println(sum);
	}
}
/*
 * try - catch 문으로 처리 할 수 있는 익셉션 중에는 반드시 그렇게 해야 하는 것도 있고, 그렇게 하지 않아도 되는 것이 있다.
 * 전자를 checked exception, 후자를 unchecked exception 이라고 한다. - 둘 사이의 구분도 익셉션 클래스의 상속 관계와 관련이 있다.
 * Exception class 에서는 RuntimeException 클래스와 그 서브 클래스 들이 unchecked exception 에 속하고
 * 그외 Exception class 와 나머지 서브 클래스들 모두 checked exception 에 속한다.
 * 현재 해당 프로그램에서는 checked exception 에 해당하는 Exception 을 발생하고 있기 때문에 컴파일 에러가 발생하고
 * ExceptionExample2 프로그램 에서는 unchecked exception 인 ArithmeticExceptino 을 발생하고 있기 때문에 컴파일은 가능하나, 실행에서 익셉션으로 인한 에러가 발생한다.
 * 해당 프로그램을 컴파일 에러가 발생하지 않게 하려면 try - catch 문으로 처리해야 한다.
 */
