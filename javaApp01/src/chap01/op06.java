package chap01;

import java.util.Scanner;

public class op06 {
	public static void main(String[] args) {
		System.out.println("숫자 입력 : ");
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		System.out.printf("출력값 : %d\n", (num>0) ? num : num * -1);
		
		num = sc.nextInt();
		System.out.printf("출력값 : %d\n", (num>0) ? num : num * -1);
		
		num = sc.nextInt();
		System.out.printf("출력값 : %d\n", (num>0) ? num : num * -1);
	}
}
