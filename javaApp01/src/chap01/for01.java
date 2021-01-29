package chap01;

import java.util.Scanner;

public class for01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		for(int i = 0; i < 3; i++) {
			System.out.println("정수 입력 : ");
			num = sc.nextInt();
			
			System.out.println("입력된 숫자 : " + num);

			if(num % 2 == 0) {
				System.out.println("짝수 또는 2의 배수 입니다.");
			}
			else {
				System.out.println("홀수 또는 2의 배수가 아닙니다.");
			}
		}
	}
}
