package Serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
 * 자바의 디폴드 직렬화 매커니즘에 따르면 직렬화 되는 객체의 클래스에 선언된 필드와(BookInfo class 에 선언된 필드), 직렬화 가능 슈퍼 클래스의 필드는 스트림으로 만들어지지만
 * 직렬화 가능 클래스가 아닌 슈퍼클래스의 필드는 스트림으로 만들어지지 않는다. - 역직렬화 할 때도 마찬가지
 * 이런 이유로 인해 BookInfo class 에 있는 필드들은 직렬화/역직렬화가 되지만, 슈퍼클래스인 GoodsInfo class 는 직렬화/역직렬화가 되지 않게 된다.
 * 직렬화 가능 클래스가 직렬화가 가능하지 않은 슈퍼클래스로부터 상속받은 필드를 직렬화하고 역직렬화 하기 위해서는 
 * 직렬화 가능 클래스 안에 직렬화 메소드와 역직렬화 메소드를 선언해야 한다. - BookInfo class 참조 
 */
public class ObjectInputExample6 {
	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output6.dat"));
			BookInfo obj = (BookInfo)in.readObject();
			System.out.println("상품 코드 : " + obj.code);
			System.out.println("상품명 : " + obj.name);
			System.out.println("가격 : " + obj.price);
			System.out.println("지은이 : " + obj.writer);
			System.out.println("페이지수 : " + obj.page);
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}
		catch(EOFException eofe) {
			System.out.println("끝");
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
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
