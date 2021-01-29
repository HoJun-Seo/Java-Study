package chap01;

import java.util.Scanner;

public class sw02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int in = sc.nextInt();
		
		// jdk 14 이후 에러없이 적용
		// -> (화살표) : 한 문장만 실행
		// {} (중괄호) : 여러문장을 실행
		switch(in) {
		case 1,3,5,7,9 -> System.out.println(in + " 홀수 입니다.");
		case 2,4,6,8,10 -> System.out.println(in + " 짝수 입니다.");
		default -> {
				System.out.println("1 부터 10까지의 수가 아닙니다.");
				System.out.println("정확한 숫자를 입력하세요");
			}
		}
	}
}
