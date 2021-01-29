package chap01;

import java.util.Scanner;

public class op05 {
	public static void main(String[] args) {
		System.out.println("두 개의 수를 띄워쓰기 하여 입력해주세요");
		Scanner sc = new Scanner(System.in);
		
		int in1 = sc.nextInt();
		int in2 = sc.nextInt();
		
		int result = (in1 > in2 ? in1 : in2);
		System.out.printf("입력한 값 중 큰수는 %d", result);
	}
}
