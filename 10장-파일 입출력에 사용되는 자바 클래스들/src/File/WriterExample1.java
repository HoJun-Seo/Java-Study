package File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterExample1 {
	public static void main(String[] args) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("output.txt"));
			char arr[] = {'뇌', '를', ' ', '자', '극', '하', '는', ' ', 'J', 'a', 'v', 'a'};
			for(int cnt = 0; cnt < arr.length; cnt++)
				writer.write(arr[cnt]);
		}
		catch(IOException ioe) {
			System.out.println("파일로 출력 할 수 없습니다.");
		}
		finally {
			try {
				writer.close();
			}
			catch(Exception e) {
			}
		}
	}
	/*
	 * FileWriter 객체를 생성하면 output.txt 라는 이름의 파일이 생성된 후에 파일이 열린다.
	 * 이미 같은 이름의 파일이 있다면, 기존 파일의 내용은 지워지게 된다.
	 * 파일을 열 때 원래 있던 파일의 내용을 유지하고 싶으면 FileWriter 생성자의 두 번째 파라미터로 true 값을 넘겨주면 된다.
	 * 예) FileWriter writer = new FileWriter("output.txt", true);
	 * 위와 같이 true 값을 넘겨주면 원래 있던 파일의 내용 뒤에 새로 쓰는 내용이 추가된다.
	 * 파일을 열고 난 다음에는 write method 를 이용해 파일에 데이터를 쓸 수 있다.
	 * write method 는 여러가지가 있는데, 그 중 가장 간단하게 사용할 수 있는 것은 하나의 문자를 파라미터로 받아서 출력하는 write method 이다.
	 * 파일에 데이터를 쓰고 나서 파일을 닫는 것은, 파일로부터 데이터를 읽고 난 후에 파일을 닫는 것보다 훨씬 더 중요한데, 데이터를 쓰고 나서
	 * 파일을 닫지 않으면 파일에 데이터가 실제로 쓰여지기도 전에 프로그램이 끝나서 데이터 손실이 일어날 수 있기 때문이다. 
	 */
}
