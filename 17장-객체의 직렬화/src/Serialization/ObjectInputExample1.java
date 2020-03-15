package Serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
/*
 * 객체를 역직렬화 하는 프로그램
 * writeObject method 와 readObject method 는 GregorianCalendar class 뿐만 아니라 모든 직렬화 가능 클래스의 객체를 직렬화 하고 역직렬화 할 수 있다.
 * 직렬화 가능 클래스란 java.io.Serializable interface 를 구현하는 클래스를 말하며, 나머지 클래스는 모두 직렬화 가능 클래스가 아니다.
 * 직접 클래스를 선언할 때는 직렬화 가능 클래스로 만들기 위해 지켜야 할 규칙과 방법이 있다.
 */
public class ObjectInputExample1 {
	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output.dat"));
			while(true) {
				GregorianCalendar calendar = (GregorianCalendar)in.readObject(); //객체를 역직렬화 하는 부분
				//readObject method : 입력된 스트림으로부터 객체를 만들어서 리턴하는 메소드
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH) + 1;
				int date = calendar.get(Calendar.DATE);
				System.out.println(year + "/" + month + "/" + date);
			}
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}
		catch(EOFException eofe) {
			System.out.println("끝");
		}
		catch(IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println("해당 클래스가 존재하지 않습니다.");
		}
		finally {
			try {
				in.close();
			}
			catch(Exception e) {
			}
		}
	}
}
