package io;

public class ex03_escapeSequence {
	public static void main(String[] args) {
		
		//	1. 자바는 콘솔 응용 프로그램 만을 위한 언어가 아니다.
		//	2. c언어 및 파이썬에서 사용하는 이스케이프 시퀀스는 대부분 사용가능
		//	3. 자바에서 자체적인 기능을 가지는 문자는 \(백 슬래시)를 앞에 붙인다.
		//	4. %는 예외적으로 %% 로 처리한다.
		
		System.out.println("헐크\t : Smash !!");
		System.out.println("엔트맨\t : 딸 아");
		System.out.println("아이언맨\t : His name is Collson");
		System.out.println("블랙위도우\t : Sun's getting real low");
		System.out.println("캡틴아메리카\t : Avengers Assemble");
		
		//어떤 프로그램은 \r\n 을 개행으로 처리하고
		//또 다른 프로그램은 \n만 있어도 개행으로 처리한다.
		
		System.out.println("Hello \r\nworld !!"); //	둘 다 넣어도 한 줄
		System.out.println("반갑구나 \n세상아 !!"); //	\n도 한 줄
		System.out.println("Goodbye \rworld !!");//	\r도 한 줄
		
		System.out.println("'집에 가고 싶을까...?'");
		System.out.println("\"라면 먹고 갈래?\"");
		System.out.printf("배터리 : 97%%\n");
		System.out.println();
		}
}
