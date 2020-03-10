package System;

import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 자바 프로그램은 표준 입출력과 환경 변수 읽기 같이 운영체제 와의 상호작용에 필요한 여러 기능들을 모아놓은 System class 를 활용할 수 있다.
 * 표준 입력과 출력을 하기 위해서는 System class 의 in 필드와 out 필드를 사용해야 한다.
 * System class 의 in 필드는 표준 입력(키보드 입력)을 위한 필드이다. 이 필드는 InputStream class 타입으로 선언되어 있는데,
 * 해당 클래스는 문자 스트림이 아니라 바이트 스트림을 입력 받는 클래스 이므로 이 클래스의 메소드를 사용해서는 한글 입력을 제대로 받을 수 없다.
 * 그래서 in 필드는 바이트 스트림을 문자 스트림으로 바꾸는 기능을 갖고 있는 InputStreamReader class 와 함께 사용한다.
 */
public class SystemExample1 {
	public static void main(String[] args) {
		InputStreamReader reader = new InputStreamReader(System.in);
		//System class 의 in 필드를 가지고 InputStreamReader 객체를 생성한다.
		//in 필드를 InputStreamReader class 와 함께 사용하기 위해서는 in 필드를 생성자 파라미터로 삼아서 해당 클래스의 객체를 생성해야 한다.
		//in 필드를 통해 입력되는 문자는 enter 키를 눌렀을때 한꺼번에 입력되나, read method 에 의해 한 글자씩 읽히게 된다.
		try {
			while(true) {
				char ch = (char)reader.read();
				/*
				 * 이렇게 생성된 객체에 대하여 read method 를 호출하면 키보드로 부터의 입력을 문자단위로 읽어 들일 수 있는데
				 * read method 를 파라미터 없이 호출하면 int 타입의 값을 리턴하는데, 그 값은 하나의 문자를 담고 있기 때문에
				 * 위와 같이 char 타입으로 캐스트 하여 사용해준다.
				 * 여기서 주의 할 점은 read method 는 IOException 을 일으킬수 있기 때문에 try - catch 문으로 처리해야 한다는 것이다.
				 */
				System.out.println("입력된 문자 : " + ch);
				if(ch == '.') break;
				//키보드로부터 한 글자씩 입력 받아서 출력하는 일을 마침표(.) 가 입력될 때 까지 반복한다.
			}
		}
		catch(IOException e) {
			System.out.println("키보드 입력 에러");
			//read method 가 발생시키는 IOException 을 처리한다.
		}
	}
}
