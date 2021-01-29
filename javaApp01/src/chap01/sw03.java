package chap01;

import java.util.Scanner;

public class sw03 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("월 입력 : ");
		int in = sc.nextInt();
		
		String season = switch (in) {
		case 12,1,2 -> "겨울"; // jdk 13 이후 -> 대신 : yield 키워드를 사용하는 것도 가능하다.
		case 3,4,5 -> "봄";
		case 6,7,8 -> "여름";
		case 9,10,11 -> "가을";
		default -> "기후 온난화";
		};
		System.out.printf("%d 월은 %s 입니다.", in, season);
	}
}
