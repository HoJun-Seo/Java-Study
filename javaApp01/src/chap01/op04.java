package chap01;

import java.util.Scanner;

public class op04 {
	public static void main(String[] args) {
		System.out.println("3 > 2 : " + (3 > 2) );
		System.out.println("3 >= 2 : " + (3 >= 2) );
		System.out.println("3 < 2 : " + (3 < 2) );
		System.out.println("3 <= 2 : " + (3 <= 2) );
		System.out.println("3 == 2 : " + (3 == 2) );
		System.out.println("3 != 2 : " + (3 != 2) );
		
		System.out.println("----------------");
		
		System.out.println("3>2 && 3>1 && 2>1 : "+(3>2 && 3>1 && 2>1));
		System.out.println("3>2 && 3>1 && 2<1 : "+(3>2 && 3>1 && 2<1));
		System.out.println("3<2 || 3<1 || 2<1 : "+(3<2 || 3<1 || 2<1));
		System.out.println("3>2 || 3<1 || 2<1 : "+(3>2 || 3<1 || 2<1));
		
		System.out.println("3>2 : " + (3>2));
		System.out.println("!(3>2) : " + !(3>2));
		
		
		
		// 삼항 연산자(조건 ? 참 : 거짓), 짝수/홀수 구분
		System.out.println("숫자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String result = num%2 == 0 ? "짝수입니다" : "홀수입니다.";
		System.out.println(num+"은 "+result);
		
	}
}
