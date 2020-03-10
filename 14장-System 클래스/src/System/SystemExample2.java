package System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 만약 줄 단위로 문자들을 입력 받고 싶으면 InputStreamReader class 와 더불어 BufferedReader class 를 함께 사용하면 된다.
 * 이 두 클래스를 함께 사용할 때는 InputStreamReader 객체를 BufferedReader class 의 생성자 파라미터로 넘겨줘야 한다.
 * 이렇게 생성된 객체에 대해 readLine method 를 호출하면 키보드로 부터 입력된 문자열을 행 단위로 읽을 수 있다.
 */
public class SystemExample2 {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//System class 의 in 필드를 가지고 BufferedReader 객체를 생성한다.
		try {
			String str = reader.readLine();
			System.out.println("입력된 문자열 : " + str);
			//키보드로부터 한 줄을 입력받아서 출력한다.
		}
		catch(IOException e) {
			System.out.println("키보드 입력 에러");
			//readLine method 가 발생시키는 IOException 을 처리한다.
		}
	}
}
