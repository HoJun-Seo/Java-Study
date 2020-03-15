package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/*
 * BBSItem 객체를 직렬화 하는 프로그램
 */
public class ObjectOutputExample3 {
	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output3.dat"));
			BBSItem obj = new BBSItem("최선희", "sunshine", "정모합시다.", "이번주 주말 어떠세요?");
			//obj.addAttachment(new Object()); //Object 타입 필드 추가 - 첨부파일
			obj.addAttachment("모카자바 500g 15500원");
			System.out.println("전체 게시물의 수 : " + obj.itemNum);
			System.out.println("글쓴이 : " + obj.writer);
			System.out.println("패스워드 : " + obj.passwd);
			System.out.println("제목 : " + obj.title);
			System.out.println("내용 : " + obj.content);
			System.out.println("첨부 : " + obj.attachment);
			out.writeObject(obj); //객체를 직렬화 하는 부분
			/*
			 * writeObject method 는 직렬화 대상 필드 중에 하나라도 직렬화 할 수 없는 필드가 존재하면 IOException 을 발생시킨다.
			 * 그로 인해 객체 전체가 직렬화 되지 않게 되어 ObjectInputExample3 프로그램에서 에러가 발생하게 된다.
			 * 이런 필드의 타입 체크는 필드의 선언된 타입이 아니라, 필드 값의 타입에 대해 이루어지기 때문에 15행의 명령문을 16행 처럼 바꿔주면 익셉션이 발생하지 않게 된다.
			 * 여기서 파라미터로 넘겨준 문자열은 attachment 필드에 대입되는데, 이 문자열의 타입인 String 클래스는 직렬화 가능 클래스이기 때문이다.
			 * 그러나 객체의 필드 값에 따라 정상 실행 여부가 결정되는 프로그램은 좋은 프로그램 이라고 할 수 없다.
			 * 그러니까 직렬화 가능 클래스를 선언 할 때는 직렬화 대상이 되는 모든 필드가 프리미티브 타입이나 직렬화 가능 클래스 타입이 되도록 선언하는 것이 좋다.
			 */
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
