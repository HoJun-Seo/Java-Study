package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;

public class ex01_IO {
	public static void main(String[] args) throws IOException {
		
		//input & output : 입출력(java 1.5 이전까지의 기본 형식)
		int num;
		System.out.print("문자 하나 입력 : ");
		num = System.in.read();
		System.out.println("num : " + num);
		System.out.println("num : " + (char)num);
		
		//System.in : 사용자의 입력을 프로그램으로 가져오는 통로(1 바이트씩 입력)
		//System.out : 프로그램의 데이터를 사용자에게 전달하는 통로(표준 출력)
		//System.err : 프로그램상의 특수한 메시지를 사용자에게 전달하는 통로(에러 출력)
		BufferedReader br; //4 바이트 짜리 참조 변수
		br = new BufferedReader(new InputStreamReader(System.in));
		//br 참조변수가 새로운 대상을 바라보게 한다.(새 객체를 생성하고 주소를 저장한다.)
		
		/*
		 * 	System.in : 1 바이트 입력 함수를 가지고 있다.
		 * 	InputStreamReader : 2 바이트 입력 함수를 가지고 있다.
		 *	BufferedReader : 버퍼 단위(일정한 크기)로 입력받는 여러 함수를 가지고 있다.
		 */
		
		System.out.println("버퍼값 처리 : " + System.in.read()); //버퍼에 남아있는 엔터 키 값을 처리해 주기 위함
		System.out.println("버퍼값 처리 : " + System.in.read()); //버퍼에 남아있는 엔터 키 값을 처리해 주기 위함
		
		System.out.println("이름 입력 : ");
		String name = br.readLine(); // 한 줄 만큼 입력
		
		System.out.println("나이 입력 : ");
		int age = Integer.parseInt(br.readLine());
		System.out.println(name + "님은" + age + "살 입니다.");
	}
}
