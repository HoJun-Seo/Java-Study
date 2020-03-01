package File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
/*
 * 객체를 파일에 읽고 쓰기 위해서는 ObjectInputStream class 와 ObjectOutputStream class 를 사용해야 한다.
 * ObjectOutputStream class 는 객체를 스트림으로 만들어서 출력하는 기능이 있는 클래스이다. 
 * 하지만 이 클래스는 데이터를 파일에 저장하는 기능이 없기 때문에 FileOutputStream class 와 함께 사용해야 한다.
 * 생성된 ObjectOutputStream 객체에 대해 writeObject 라는 메소드를 호출하면 파라미터로 넘겨진 객체가 파일에 저장된다.
 * 예) out2.writeObject(obj); -> 객체를 출력하는 메소드
 * 하지만 위와 같은 메소드로 어떤 객체든지 모두 출력할 수 있는 것은 아니다. 위와 같은 메소드는 직렬화 가능 객체(Serializable object)만
 * 출력할 수 있다.
 * 객체를 스트림으로 만드는 것을 객체의 직렬화(Serialization)라고 한다. 그런데 객체의 직렬화 가능 여부는 그 객체를 생성하는데 사용한 클래스에 의해 결정된다.
 * 직렬화 가능한 클래스인지 여부는 그 클래스가 java.io.Serializable 인터페이스를 구현하는지 아닌지에 달려있다.(클래스들의 API 규격서 참조)
 * 예) GregorianCalendar class 는 직렬화 가능 클래스 이지만 StringTokenizer class 는 그렇지 않다.
 */
public class ObjectOutputExample1 {
	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output2.dat"));// 파일을 연다.
			out.writeObject(new GregorianCalendar(2006, 0, 14)); //GregorianCalendar 객체를 생성해서 파일에 쓴다.
			out.writeObject(new GregorianCalendar(2006, 0, 15));
			out.writeObject(new GregorianCalendar(2006, 0, 16));
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
