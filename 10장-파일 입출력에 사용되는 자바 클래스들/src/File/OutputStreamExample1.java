package File;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamExample1 {
	public static void main(String[] args) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("output.dat");
			byte arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
			for(int cnt = 0; cnt < arr.length; cnt++)
				out.write(arr[cnt]);
		}
		catch(IOException ioe) {
			System.out.println("파일로 출력 할 수 없습니다.");
		}
		finally {
			try {
				out.close();
			}
			catch(Exception e) {
			}
		}
	}
	/*
	 * FileOutputStream class 는 FileWriter class 와 아주 비슷하나 파라미터를 넘겨주는 부분이 다르다.
	 * 이 클래스의 write method 는 파라미터를 문자가 아니라 바이트 데이터로 취급한다.
	 * 예를 들어 FileOutputStream 객체에 대해 아래와 같이 write method 를 호출하면 71 에 해당하는 비트패턴 01000111 을 갖는 
	 * 하나의 바이트가 파일로 출력된다.
	 * outputStream.write(71);
	 * FileOutputStream class 를 통해 생성된 파일의 내용은 문자 데이터가 아니기 때문에 텍스트 에디터로 내용을 확인 할 수 없다.
	 * FileOutputStream class 를 통해 생성된 파일의 내용은 FileInputStream class 를 통해 내용을 확인할 수 있다.
	 */
}
