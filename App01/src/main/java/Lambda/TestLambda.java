package Lambda;

import LambdaInterface.PrintString;

public class TestLambda {

	public static void main(String[] args) {
		// 람다식을 인터페이스 형 변수에 대입하고, 그 변수를 사용해 람다식 구현부 호출
		PrintString lambdaStr = s -> System.out.println(s);
		lambdaStr.showString("hello lambda_1");
		
		// 메소드의 매개변수로 람다식을 대입한 변수 전달
		// 굳이 이런식으로 작성해야 할 이유는 잘 모르겠다.(괜히 빨리 갈 수 있는 길을 돌아가는 느낌?)
		showString(lambdaStr);
		
		// 람다식의 반환값 활용
		PrintString reStr = returnString(); // 변수로 람다식 반환
		reStr.showString("hello ");
	}

	// 람다식 반환 메소드
	public static PrintString returnString() {
		return s -> System.out.println(s + " world");
	}

	public static void showString(PrintString p) {
		p.showString("hello lambda_2");
	}

}
