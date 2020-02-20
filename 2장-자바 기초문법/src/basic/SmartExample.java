package basic;

public class SmartExample {
	public static void main(String[] args) {
		int a = 3, b = 0;
		int result;
		try {
			result = a / b;
			System.out.println(result);
		}
		catch(java.lang.ArithmeticException e) { //3을 0으로 나눔 - 불가능한 연산에 의한 익셉션
			System.out.println("잘못된 연산입니다.");
		}
		System.out.println("Done");
		//finally 블록은 생략 가능하다.
		/*finally {
			System.out.println("Done");
		}*/
		/*
		 * try-catch 문 : exception 처리를 위한 문법
		 * try 블록에는 익셉션이 발생할 가능성이 있는 명령문을 써넣어야 하고
		 * catch 블록에는 그 익셉션을 처리하는 명령문을 써넣어야 한다.(try 블록에서 익셉션 발생시 catch 블록 실행)
		 * finally 블록 안에는 익셉션 발생 여부와 관계없이 맨 마지막에 실행할 명령문 들을 써넣어야 한다.
		 * 
		 * java.lang.ArithmeticException e
		 *  : java.lang.ArithmeticException - 익셉션 변수의 타입
		 *    반드시 발생하는 익셉션의 종류와 맞아야 하므로 프로그래머가 임의로 지정할 수 없다.
		 *  : e - 익셉션 변수의 이름
		 *    다른 변수의 경우와 마찬가지로 프로그래머가 나름대로 정할 수 있다.
		 */
	}
}
