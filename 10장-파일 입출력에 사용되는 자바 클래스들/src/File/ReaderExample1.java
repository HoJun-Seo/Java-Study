package File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderExample1 {
	public static void main(String[] args) {
		FileReader reader = null; //익셉션 처리와 finally 블록의 reader 객체 변수 사용을 위해 try - catch 문 밖에서 객체를 선언해준다.
		try {
			reader = new FileReader("poem.txt");
			while(true) {
				int data = reader.read();
				if(data == -1) break;
				char ch = (char)data;
				System.out.print(ch);
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
			//FileNotFoundException - 읽고자 하는 파일이 없을 때 발생하는 익셉션
		}
		catch(IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
			//IOException - 입출력에 관한 일반적인 오류가 있을 때 발생하는 익셉션
		}
		finally {
			try {
				reader.close();
				/*
				 * close method 가 main 함수 내에 있을 경우 read method 에서 IOException 이 발생하면
				 * 프로그램의 실행 흐름은 아래쪽에 있는 catch 블록으로 이동하는데, 그렇게 되면 main 함수 내에 있는
				 * close method 를 건너뛰게 되는데, 이때 파일이 열려 있는 채로 프로그램이 끝나버리면
				 * 파일을 열 때 할당받았던 시스템 자원이 해제되지 않아 문제가 될 수 있다.
				 * 그렇기 때문에 catch 문 이후 finally 문을 사용하여 close method 를 호출해줌으로서 파일이 닫히지 않고 프로그램이 종료되는 것을 방지한다.
				 * finally 블록은 익셉션이 발생하든 안 하든 try 문의 맨 마지막에 실행되기 때문에 이런식으로 작성된 프로그램에서는 열었던 파일을 닫지 않고
				 * 프로그램을 끝낼 염려가 생기지 않게된다.
				 */
			}
			catch(Exception e) {
			}
		}
	}
	/*
	 * FileReader class 를 이용한 텍스트 파일 읽기
	 * 텍스트 파일로부터 데이터를 읽기 위해서는 파일을 열고, 데이터를 읽고, 파일을 닫는 세가지 작업을 해야한다.
	 * FileReader class 안에는 이 세 가지 작업에 필요한 기능들이 모드 들어있다.
	 * 파일을 여는 기능은  FileReader class 의 생성자 안에 들어있다, 텍스트 파일을 열기 위해서는 위와 같이 파일 이름을 생성자 파라미터로 
	 * 사용해서 FileReader 객체를 생성해준다.
	 * 객체를 생성하면 파일은 열리고, 파일 내용을 읽는데 필요한 모든 정보는 FileReader 객체 안에 세팅이 된다.
	 * 파일의 내용을 읽는 일은 read method 를 이용해서 할 수 있다. read method 는 하나가 아니라 여러개가 있는데, 그 중 가장 간단한 것은
	 * 파라미터를 받지 않는 read method 인데, 이 메소드는 파일로부터 한 개의 문자를 읽어서 리턴하는 기능을 한다.(호출 될때마다 순서대로 읽음)
	 * read method 의 return type 은 char 형이 아닌 int 타입이다. - 메소드가 char 타입의 표현범위를 벗어난 다른 정보도 리턴하기 때문이다.
	 * 파일의 끝에 도달하여 더 이상 읽을 데이터가 없다면 -1 을 리턴한다. 이 -1 이라는 값은 read method의 반복적인 호출을 중단한다는 신호로 사용된다.
	 * 파일을 닫는 기능은 close method 인에 있다. 이 메소드는 파라미터를 받지 않고 리턴값도 없기 때문에 위와 같이 reader.close() 의 형태로 호출된다.
	 */
}
