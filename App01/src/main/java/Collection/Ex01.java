package Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("몇개의 예상번호를 출력 하시겠습니까? : ");
		int count = Integer.parseInt(br.readLine());
		int repeat_count = 0;
		
		while(repeat_count < count) {
			int[] lotto=  new int[7];
			for(int i = 0; i < lotto.length; i++) {
				int number = (int)(Math.random()*45+1);
				if(Arrays.stream(lotto).anyMatch(x -> x == number))
					i--;
				else
					lotto[i] = number;
			}
			
			Arrays.sort(lotto);
			for(int i = 0; i < lotto.length-1; i++) {
				System.out.printf("%d, ", lotto[i]);
			}
			System.out.println("보너스 : " + lotto[lotto.length-1]);
			repeat_count++;
		}
		
	}
}

/*
 * 문제1)
 * 로또 예상 번호를 몇 개 생성할지를 키보드로 입력받아서
 * 그 수만큼 로또 예측번호 6개를 정렬한 뒤 출력하고 
 * 맨 뒤에 7번째 예측 번호는 '보너스' 를 붙여서 다음 실행결과 예와 같이 출력
 * 숫자의 범위는 1 ~ 45 사이 입니다.
 * 
 * 예시 : 실행)
 * 몇개의 예상 번호를 출력 하시겠습니까? : 2
 * 40,43,21,39,35,14 + 보너스 36
 * 31,44,6,12,8,11 + 보너스 2
 * 
 * 문제2)
개미 수열의 법칙을 이용해서 총 10번의 결과를 출력
개미수열의 법칙)
 - 시작은 1이다
 - 대상숫자와 대상이되는 숫자가연속으로 몇 개인지를 작성한다.
 예) 1->11(1이 1개) -> 12 -> 1121(1이 1개, 2가 1개) -> 122111(1이 2개, 2가 1개, 1이 1개)...
 */
