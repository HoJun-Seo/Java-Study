package File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
/*
 * LineNumberReader class 는 텍스트를 읽어들일 때 ,행 번호를 붙이면서 읽는 기능의 클래스이다.
 * 이 클래스를 FileReader class 와 함께 사용하면 행 번호를 붙여가면서 텍스트 파일을 읽을 수 있다.
 * 텍스트 파일에 행 번호를 붙이면서 읽기 위해서는 FileReader 객체를 생성한 다음에 그 객체를 생성자 파라미터로 사용해서 LineNumberReader 객체를 생성해야 한다.
 * 생성된 LineNumberReader 객체에 대해서 readLine method 를 호출하면 텍스트 파일의 내용을 한 줄 씩 읽을 수 있다.
 * String str = reader.readLine(); - 이 메소드는 파일의 끝에 도달하여 더 이상 읽을 행이 없으면 null 을 리턴한다.
 * 읽어들인 행의 번호는 getLineNumber method 를 이용해서 가져올 수 있다.
 * int lineNo = reader.getLineNumber(); - 바로 전에 읽은 행 번호를 리턴하는 메소드
 */
public class LineNumberExample1 {
	public static void main(String[] args) {
		LineNumberReader reader = null;
		try {
			reader = new LineNumberReader(new FileReader("poem2.txt"));
			while(true) {
				String str = reader.readLine();
				if(str == null) break;
				int lineNo = reader.getLineNumber();
				System.out.println(lineNo + ": " + str);
				//파일로부터 한 행씩 읽어서 행 번호와 함께 출력한다.
			}
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}
		catch(IOException ioe) {
			System.out.println("파일을 읽을수 없습니다.");
		}
		finally {
			try {
				reader.close();
			}
			catch(Exception e) {
			}
		}
	}
}
