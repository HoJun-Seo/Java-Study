package Serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
 * GoodsStock 객체를 역직렬화 하는 프로그램
 * 직렬화가 가능하지 않은 클래스에 직렬화를 하려고 하면 컴파일은 문제 없이 실행되나, 프로그램을 실행할때 익셉션과 같은 에러가 발생한다.
 * java.io.Serializable interface 를 구현하는 클래스의 객체는 writeObject method, readObject method 를 이용해서 파일에 읽고 쓸 수 있지만
 * 그렇지 않은 클래스의 객체는 그렇게 할수 없다.
 */
public class ObjectInputExample2 {
	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output2.dat"));
			while(true) {
				GoodsStock obj = (GoodsStock)in.readObject(); //객체를 역직렬화 하는 부분
				System.out.println("상품 코드 : " + obj.code + "\t 상품수량 : " + obj.num);
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
