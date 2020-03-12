package Exception;

import java.io.FileReader;
import java.io.IOException;
/*
 * catch 절에서 익셉션을 받을 때 사용하는 변수를 익셉션 파라미터 변수 라고 한다.
 * 익셉션 파라미터 변수는 익셉션 객체를 받는 데 사용되기 때문에 익셉션 객체를 대입 할 수 있는 타입으로 선언해야 한다.
 * 그런데 이 변수는 익셉션 객체를 받아들이는 수동적인 역할만 하는 것이 아니라, catch 절이 처리할 익셉션 객체를 골라서 잡아내는 역할까지 한다.
 * 익셉션 파라미터는 그와 똑같은 타입의 익셉션만 잡을수 있는 것이 아니라, 선언된 타입의 서브 클래스 타입의 익셉션도 잡아낼 수 있다.
 */
public class ExceptionExample8 {
	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("some.txt");
			//FileNotFoundException 이 발생하는 부분
			reader.close();
		}
		catch(IOException e) {
			//FileNotFoundException 은 IOException 의 서브 클래스 타입 익셉션이다.
			String str = e.getMessage();
			System.out.println(str);
		}
	}
}
