package Basic_class;

import java.util.Random;

public class RandomExample1 {
	public static void main(String[] args) {
		Random random = new Random();
		//Random random = new Random(349239L); -> seed 값을 넘겨주고 생성한 Random 객체는 프로그램을 몇 번을 실행해도 
		//항상 똑같은 순서로 똑같은 난수를 발생시킨다.
		System.out.println(random.nextInt(100));
		System.out.println(random.nextInt(100));
		System.out.println(random.nextInt(100));
		//nextInt method 를 이용하여 0 부터 99까지의 정수 하나를 출력한다.
	}
}
