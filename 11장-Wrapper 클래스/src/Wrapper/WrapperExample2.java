package Wrapper;
/*
 * 래퍼 클래스에서는 문자열 파라미터를 받는 생성자도 있다. 그 생성자는 파라미터로 받은 문자열을 해석하여 프리미티브 타입의 값으로 만든 후에 래퍼 객체 안에 저장한다.
 * 래퍼 클래스의 문자열 파라미터를 받는 생성자와 앞에서 배웠던 Value method를 함께 사용하면 문자열을 프리미티브 타입의 값으로 바꿀수 있다.
 */
public class WrapperExample2 {
	public static void main(String[] args) {
		int total = 0;
		for(int cnt = 0; cnt < args.length; cnt++) {
			Integer obj = new Integer(args[cnt]); //명령형 파라미터로 받은 문자열을 가지고 Integer 객체를 생성한다.
			total += obj.intValue(); //Integer 객체 안에 있는 int 값을 가져온다.
			//파라미터로 아무런 값도 넘겨주지 않으면 0 을 출력하고 정수를 넘겨주면 정수들의 합계를 출력한다.
		}
		System.out.println(total);
	}
}
