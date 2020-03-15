package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
/*
 * 10장에서 작성했던 객체 직렬화 프로그램
 * 자바 프로그램에서는 모든 입출력 데이터를 스트림 형태로 주고 받는다, 파일에 저장하는 데이터도 스트림 형태로 읽고 쓰고, 네트워크를 통해 데이터를 전송할때도
 * 스트림 형태로 전송한다. 그렇기 때문에 객체를 파일에 저장하거나 네트워크로 전송하기 위해서는 객체를 스트림으로 만드는 작업이 필요하다.
 * 이렇게 객체를 스트림으로 만드는 작업을 직렬화(Serialization) 라고 하고 프로그램에 입력된 스트림으로부터 다시 객체를 만들어 내는 작업을 역직렬화(deserialization) 라고 한다.
 * 객체의 직렬화와 역직렬화 기능은 jdk 라이브러이에 있는 ObjectOutputStream class 와 ObjectInputStream class 가 제공한다.
 */
public class ObjectOutputExample1 {
	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output.dat"));
			out.writeObject(new GregorianCalendar(2006, 0, 14));
			out.writeObject(new GregorianCalendar(2006, 0, 15));
			out.writeObject(new GregorianCalendar(2006, 0, 16));
			//writeObject method : 파라미터로 넘겨준 객체를 스트림으로 만들어서 출력하는 메소드
		}
		catch(IOException ioe) {
			System.out.println("파일로 출력할 수 없습니다.");
		}
		finally {
			try {
				out.close();
			}
			catch(Exception e) {
			}
		}
	}
}
