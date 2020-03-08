package Wrapper;
/*
 * 프리미티브 타입의 비트 패턴을 가져오는 정적 메소드
 * Integer 와 Long 클래스 에 있는 toBinaryString method 는 파라미터로 넘겨준 int 값과 long 값의 내부 비트 패턴을 문자열로 만들어서 리턴하는 메소드이다.
 * 예) String str1 = Integer.toBinaryString(9); - "1001" 을 리턴
 * Float 와 Double class 에는 이런 메소드가 없지만, float, double 타입의 값을 그와 똑같은 비트 패턴을 갖는 int, long 타입의 값으로
 * 만드는 아래와 같은 메소드가 있다.
 * 예) int num1 = Float.floatToRawIntBits(1.5f); //1.5f와 똑같은 비트 패턴의 int 값을 리턴
 * 예) long num2 = Double.doubleToRawLongBits(1.0005); //1.0005 와 똑같은 비트 패턴의 long 값을 리턴
 * 이 메소드를 Integer, Long class 의 toBinaryString method 와 함께 사용하면 float 와 double 타입의 내부 비트 패턴을 문자열로 만드는 프로그램도 작성할 수 있다.
 */
public class WrapperExample3 {
	public static void main(String[] args) {
		int total = 0;
		for(int cnt = 0; cnt < args.length; cnt++)
			total += Integer.parseInt(args[cnt]);//명령형 파라미터로 받은 문자열을 int 타입의 값으로 바꿔서 합산한다.
		System.out.println(total);
	}
}
/*
 * 문자열을 프리미티브 타입으로 바꾸는 정적 메소드
 * 래퍼 클래스에는 파라미터로 받은 문자열을 해석하여 프리미티브 값으로 만들어서 리턴하는 다음과 같은 정적 메소드도 있다.
 * byte num1 = Byte.parseByte("1");
 * short num2 = Short.parseShort("123");
 * int num3 = Integer.parseInt("12345");
 * .......
 * 위와 같은 parse method 들은 래퍼 객체를 생성하지 않고 문자열을 해석하기 때문에 WrapperExample2.java 와 같은
 * 문자열 파라미터를 받는 생성자보다 효율적이다. - 래퍼 객체를 생성하지 않음
 * 현 프로그램은 WrapperExample2.java 를 parse method 를 이용하여 수정한 결과이다.
 */
