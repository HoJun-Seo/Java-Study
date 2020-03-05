package File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterExample1 {
	public static void main(String[] args) {
		BufferedWriter writer = null;
		/* 문자 출력 스트림의 성능을 향상 시키는 클래스 - 파일 출력의 성능을 향상 시키려면 FileWriter 객체를 생성하여 
		 * 생성자 파라미터로 넘겨줘야 한다.
		 * write method 를 이용해서 데이터를 출력할 수 있는데, 호출할 때 마다 파일에 데이터를 쓰는 것이 아니라 
		 * BufferedWriter 객체 내부에 있는 버퍼에 데이터를 모아두었다가 버퍼가 꽉 차면 한꺼번에 출력하기 때문에
		 * 잦은 보조 기억장치 접근으로 인한 프로그램의 성능 저하를 막을 수 있다.
		 * 이 클래스는 버퍼가 다 차기 전까지는 파일에 실제로 데이터를 쓰지 않기 때문에, 한 프로그램이 파일에 데이터를 쓰는 동안 
		 * 다른 프로그램이 그 파일의 내용을 사용하려고 하면 문제가 될 수 있다.
		 * 그럴때는 BufferedWriter class 의 flush method 를 이용하면 된다.
		 * 이 메소드는 호출되는 즉시 버퍼에 있는 데이터를 모드 파일에 쓰고 나서 버퍼를 비우는 메소드이다.
		 * 이 메소드는 파라미터도 받지 않고, 리턴 값도 없기 때문에 아래와 같은 방법으로 호출 할 수 있다.
		 * writer.flush(); -> 호출되는 즉시 버퍼의 데이터를 모두 출력하는 메소드.
		 */
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
