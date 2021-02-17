package FunctionalInterface;

import java.util.function.Consumer;

public class FunEx03 {
	public static void main(String[] args) {
		Consumer<Integer> consumer = x -> {
			for(int i = 1; i < 10; i++) {
				System.out.println(x + " * " + i + " = " + x*i);
			}
		};
		
		consumer.accept(2);
	}
}

/*
 * 매개변수를 받아서 해당하는 구구단을 출력하는 람다식을 작성하고
 * 매개변수로 2부터 9단까지 넣어서 구구단을 모두 출력하게 작성
 * - Consumer 함수형 인터페이스 활용 : 매개변수1개, 리턴값 없음
 */
