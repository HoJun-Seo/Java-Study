package Exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/*
 * 하나의 try 문 안에 IOException 과 FileNotFoundException 을 잡는 두 개의 catch 절이 있을 경우
 * 같은 try 문에 속하는 catch 절 들은 순서대로 처리되기 때문에 이 프로그램에서 발생한 FileNotFoundException 은 첫번째 catch 절에 의해 처리되고
 * 처리된 익셉션은 소멸하기 때문에 두번째 catch 절에 잡히지 않는다.
 * 두 catch 절의 위치가 바뀔경우 컴파일 에러가 발생한다.
 * 첫번째로 온 IOException 을 잡는 catch 절이 FileNotFoundException 까지 잡아버려서 뒤에 오는 catch 절이 할 일이 없어졌기 때문이다.
 * 자바 컴파일러는 이렇게 실행될 가능성이 전혀없는 명령문이 있는 프로그램에 대해서도 컴파일 에러가 발생한다.
 */
public class ExceptionExample9 {
	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("some.txt");
			reader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
		catch(IOException e) {
			String str = e.getMessage();
			System.out.println(str);
		}
	}
}
