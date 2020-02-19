package io;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		//기본 입출력을 활용하여 다음 문제를 풀어보자
		
		/*
		 * 1.	이름(문자열), 나이(정수), 키(실수)를 차례대로 입력 받는다.
		 * 2.	현재 연도를 변수에 저장한다.
		 * 3.	현재 연도 - 나이를 활용하여 출생년도를 계산하여 변수에 저장한다.
		 * 4.	출력할 때 이름은 쌍따옴표로 묶어서 출력하세요
		 * 5.	나이는 만 나이로 계산하여 출력하세요
		 * 6.	키는 소수점 둘째자리 까지 출력하세요
		 * 7.	출생년도를 같이 출력합니다.
		 * 8.	각 항목은 일정한 간격으로 : 을 사이에 두고, 왼쪽에 항목이름, 오른쪽에 값을 출력합니다.
		 * 
		 * 		이름 : "이지은"
		 * 		나이 : 28살
		 * 		출생년도 : 1993년
		 * 		키 : 162.70cm
		 */
		Scanner sc = new Scanner(System.in);
		
		String name;
		int age;
		int year = 2020;
		int birth;
		double height;
		
		System.out.print("이름 입력 : ");
		name = sc.nextLine();//string 자료형을 반환하는 함수(nextLine)
		
		System.out.println("나이 입력 : ");
		age = Integer.parseInt(sc.nextLine()); //wrapper class 활용
						//int 자료형을 반환하는 함수(parseInt)
		
		birth = year - (age-1);
		
		
		System.out.println("키 입력 : ");
		height = Double.parseDouble(sc.nextLine());//double 자료형을 반환하는 함수(parseDouble)
		
		System.out.println("이름 :\t" + "\"" + name + "\"");
		System.out.println("나이 :\t만 " + (age-1) + "살");
		System.out.println("출생년도 :\t" + birth + "년");
		System.out.printf("키 :\t%.2fcm", height);
		
	}
}
