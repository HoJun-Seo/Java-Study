package File;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
/*
 * ObjectInputStream class 는 스트림 형태로 읽어들인 객체를 프로그램에서 사용할 수 있는 객체로 만드는 기능의 클래스이다.
 * 그렇기 때문에 이 클래스를 FileInputStream class 와 함께 사용하면 파일에 저장된 객체를 프로그램에서 다시 읽어서 사용할 수 있다.
 * 객체를 생성하고 난 다음에는 ObjectInputStream class 의 readObject method 를 이용해서 파일에 저장된 객체를 읽어올 수 있다.
 * 그런데 이 메소드의 리턴 타입은 Object class 타입이다.
 * Object 는 자바의 다른 모든 클래스들의 슈퍼 클래스로 존재하는 특별한 클래스 인데, 이 클래스 타입으로 리턴된 객체를 원래의 클래스 타입으로
 * 사용하기 위해서는 캐스트 연산을 거쳐서 원래 타입의 변수에 대입해야 한다.
 */
public class ObjectInputExample1 {
	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output2.dat"));
			while(true) {
				GregorianCalendar calendar = (GregorianCalendar)in.readObject();
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
