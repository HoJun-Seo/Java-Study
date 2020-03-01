package File;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
 * DataOutputStream class 를 이용하여 파일에 저장했던 데이터를 프로그램으로 다시 읽어오기 위해서는 DataInputStream class 를
 * 이용하여 프로그램으로 다시 읽어 들일 수 있다.
 * 그런데 이 클래스는 입력 바이트 스트림을 프리미티브 타입 데이터로 만드는 기능은 있지만, 파일로부터 데이터를 읽는 기능은 없다.
 * 그렇기 때문에 이 클래스는 FileInputStream class 와 함께 사용해야 한다.
 */
public class DataInputExample1 {
	public static void main(String[] args) {
		DataInputStream in = null;
		try {
			in = new DataInputStream(new FileInputStream("output1.dat"));
			while(true) {
				int data = in.readInt();
				/*
				 * DataInputStream 객체를 생성한 다음에는 위와 같은 메소드를 사용하면 파일로부터 프리미티브 타입의 데이터를 읽어 올 수 있다.
				 * 예)int readInt() - 4바이트를 읽어서 int 타입으로 리턴하는 메소드
				 */
				System.out.println(data);
			}
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}
		catch(EOFException eofe) {
			System.out.println("끝");
			/*
			 * 위와 같은 readInt method 와 같은 메소드들은 파일의 마지막에 도달하여 더 이상 읽을 데이터가 없으면 EOFException 을 발생한다.
			 * 그렇기 때문에 위와 같은 메소드를 호출하는 프로그램 에서는 지금 코드와 같이 try - catch 문을 이용하여 익셉션을 처리해야 한다.
			 */
		}
		catch(IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
		finally {
			try {
				in.close();
				//내부적으로  FileInputStream class 의 close method 를 호출 시키는 DataInputStream class 의 close method 를 호출하여
				//파일을 닫는다.
			}
			catch(Exception e) {
			}
		}
	}
}
