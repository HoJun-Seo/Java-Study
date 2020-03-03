package File;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDump {
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Usage : java FileDump <filename>");
			return;
		}
		BufferedInputStream in = null;
		//버퍼를 이용하여 입출력 성능을 향상 시킨다.
		/*
		 * BufferedInputStream class 의 read method 는 메소드를 한번 호출하는데 필요한 데이터만 읽어오는 것이 아니라
		 * 그 다음에 필요한 데이터도 한꺼번에 읽어다가 객체 내부의 버퍼에 저장한다.
		 * 그 다음에 read method 가 호출되었을때는 파일의 데이터가 아니라 버퍼에 있는 데이터를 리턴한다.
		 */
		/*
		 * 이 프로그램의 경우 read method 를 처음 호출했을땐 파일로부터 버퍼 크기만큼의 데이터를 한꺼번에 읽어온 후, 그 중 16바이트 만 리턴한다.
		 * 그리고 그 다음에, read method 가 호출되면 버퍼의 두번째 16바이트를 리턴한다.
		 * 이런식으로 버퍼의 데이터를 계속 리턴하다가 더 이상 데이터가 없거나 충분치 않으면 파일로부터 데이터를 한꺼번에 읽어다가 버퍼를 다시 채운다.
		 * 객체 내부에 있는 버퍼의 크기는 이 프로그램의 경우 디폴트 값을 가지지만 객체를 생성할때 두번째 파라미터로 정수를 넘겨주면 
		 * 그 크기(바이트 단위)의 버퍼가 생성된다.
		 */
		try {
			in = new BufferedInputStream(new FileInputStream(args[0])); //파일을 연다.
			byte arr[] = new byte[16];
			while(true) {
				int num = in.read(arr); //파일로부터 16바이트를 읽는다.
				//파일로부터 문자가 아니라 바이트 단위로 데이터를 읽어서 리턴한다.
				//byte 배열을 파라미터로 받는다.
				if(num < 0)
					break;
				for(int cnt = 0; cnt < num; cnt++)
					System.out.printf("%02X ", arr[cnt]);
				//읽어들인 바이트 데이터를 16진수로 출력한다.
				System.out.println();
			}
		}
		catch(FileNotFoundException fnfe) {
			System.out.println(args[0] + "파일이 존재하지 않습니다.");
		}
		catch(IOException ioe) {
			System.out.println(args[0] + "파일을 읽을 수 없습니다.");
		}
		finally {
			try {
				in.close(); //파일을 닫는다.
			}
			catch(Exception e) {
			}
		}
	}
	/*
	 * 파일의 내용을 16 바이트씩 읽어들인 후, 각 바이트를 16진수로 만들어서 출력한다.
	 * 명령행에서 파일 이름을 입력 받는다.(output.dat)
	 */
}
