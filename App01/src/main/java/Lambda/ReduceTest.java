package Lambda;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class ReduceTest {

	public static void main(String[] args) {
		String[] greetings = {"안녕하세요~~~", "hello", "Good morning", "반갑습니다^^"};
		// 람다식을 직접 구현하는 경우
		System.out.println(Arrays.stream(greetings).reduce("", (s1,s2) -> {
			if(s1.getBytes().length >= s2.getBytes().length)
				return s1;
			else return s2;
		}));
		
		// BinaryOperator 를 구현한 클래스를 사용하는 경우
		String str = Arrays.stream(greetings).reduce(new CompareString()).get();
		System.out.println(str);
	}
}

class CompareString implements BinaryOperator<String>{

	@Override
	public String apply(String s1, String s2) {
		if(s1.getBytes().length >= s2.getBytes().length)
			return s1;
		else return s2;
	}
}
