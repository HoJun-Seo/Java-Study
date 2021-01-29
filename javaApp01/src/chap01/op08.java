package chap01;

import java.util.Scanner;

public class op08 {
	public static void main(String[] args) {
		System.out.println("숫자 입력 : ");
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("짝수 : " + num);
		}else {
			System.out.println("홀수 : " + num*-1);
		}
	}

}
