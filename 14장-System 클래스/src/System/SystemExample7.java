package System;
/*
 * 자바 프로그램의 실행과 관련된 메소드 - exit method
 * 자바 프로그램은 main method 에서 return 문을 만나면 끝이 나지만, 복잡한 프로그램의 경우에는 다른 메소드 안에서 프로그램을 끝내야 하는 경우도 있다.
 * 그럴때는 System class 의 exit method 를 호출한다. 이 메소드는 호출되는 즉시 자바 프로그램을 끝내는 메소드이다.
 * exit method 에는 int 타입의 파라미터를 넘겨줘야 한다. 이 파라미터 값은 보통은 사용되지 않지만 다른 프로그램에 의해 자바 프로그램이 호출되었을 경우에는 
 * 그 프로그램에 의해 사용될 수도 있다.
 * 관례에 따르면 이 파라미터 값이 0 일때는 프로그램이 정상 종료되었음을 표시하고, 0 이 아닌 값일 때는 할 일을 마치지 못하고 비정상 종료 하였음을 표시한다.  
 */
public class SystemExample7 {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Usage : java SystemExample7 <정수> <정수>");
			System.exit(1); //명령행 파라미터의 수가 맞지 않으면 비정상 종료
		}
		try {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int sum = num1 + num2;
			System.out.println("sum = " + sum);
			System.exit(0); //할 일을 마치고 정상 종료
		}
		catch(NumberFormatException e) {
			System.err.println("잘못된 숫자입니다.");
			System.exit(-1); //익셉션이 발생하면 비정상 종료
		}
	}
}
