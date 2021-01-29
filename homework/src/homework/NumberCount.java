package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberCount {
	public static void main(String[] args) throws IOException {
		int number = (int)(Math.random()*5+1);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		
		System.out.println("숫자 맞추기 프로그램 입니다.(1 ~ 5 사이의 숫자)");
		
		while(true) {
			System.out.println("숫자를 입력하십시오 : ");
			int input_number = Integer.parseInt(br.readLine());
			if(input_number == number) {
				System.out.println("숫자를 맞추셨습니다.");
				count++;
				break;
			}
			else {
				System.out.println("틀렸습니다.");
				count++;
				continue;
			}
		}
		
		System.out.println("정답 시도 횟수 : " + count);
	}

}
