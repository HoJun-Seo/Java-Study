package FunctionalInterface;

import java.util.function.BiFunction;

public class FunEx04 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		BiFunction<Integer, Integer, Integer> plus = (a,b) -> cal.plus(a, b);
		BiFunction<Integer, Integer, Integer> minus = (a,b) -> cal.minus(a, b);
		
		int sum = minus.apply(4, 3);
		sum = plus.apply(sum, 8);
		sum = plus.apply(sum, 9);
		
		System.out.println(sum);
		
		System.out.println("-- 메소드 참조 --");
		BiFunction<Integer, Integer, Integer> plus1 = cal::plus;
		BiFunction<Integer, Integer, Integer> minus1 = cal::minus;
		int sum1 = minus.apply(4, 3);
		sum1 = plus.apply(sum1, 8);
		sum1 = plus1.apply(sum1, 9);
		System.out.println(sum1);
	}
}

class Calculator{
	public int plus(int a, int b) {
		return a + b;
	}
	public int minus(int a, int b) {
		return a - b;
	}
}
