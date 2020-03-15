package Serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
 * BBSItem 객체를 역직렬화 하는 프로그램
 * 직렬화하기 전에는 1과 "sunshine" 이라는 값을 갖고 있던 itemNum 필드와 transient 필드가 역직렬화 후에는 0과 null 이라는 값을 가지고 있다.
 * 이것은 두 필드가 직렬화 대상에서 제외 되었기 때문이며, 두 필드의 값은 직렬화 되지도 않고, 역직렬화 되지도 않았다.
 * 직렬화 가능 클래스는 정적 필드와 transient 필드를 제외한 모든 필드들을 직렬화 한다. - 디폴트 직렬화 메커니즘
 */
public class ObjectInputExample3 {
	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output3.dat"));
			BBSItem obj = (BBSItem)in.readObject(); //객체를 역직렬화 하는 부분
			System.out.println("전체 게시물의 수 : " + obj.itemNum);
			System.out.println("글쓴이 : " + obj.writer);
			System.out.println("패스워드 : " + obj.passwd);
			System.out.println("제목 : " + obj.title);
			System.out.println("내용 : " + obj.content);
			System.out.println("첨부 : " + obj.attachment);
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
