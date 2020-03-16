package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/*
 * Rectangle 객체를 직렬화 하는 프로그램
 */
public class ObjectOutputExample7 {
	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output7.dat"));
			Rectangle obj = new Rectangle(100, 200);
			System.out.println("넓이 : " + obj.width);
			System.out.println("높이 : " + obj.height);
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
