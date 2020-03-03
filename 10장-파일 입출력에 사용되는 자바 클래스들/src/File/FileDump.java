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
