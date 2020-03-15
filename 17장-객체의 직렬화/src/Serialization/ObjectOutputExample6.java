package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//BookInfo class 를 직렬화 가능 클래스로 만들었을때 객체를 직렬화 하는 프로그램은 올바르게 실행된다.
public class ObjectOutputExample6 {
	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output6.dat"));
			BookInfo obj = new BookInfo("80801", "반지의 제왕", 20000, "톨킨", 636);
			System.out.println("상품 코드 : " + obj.code);
			System.out.println("상품명: " + obj.name);
			System.out.println("가격 : " + obj.price);
			System.out.println("지은이 : " + obj.writer);
			System.out.println("페이지수 : " + obj.page);
			out.writeObject(obj);
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
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
