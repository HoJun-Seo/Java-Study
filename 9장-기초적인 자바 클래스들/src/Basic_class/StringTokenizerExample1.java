package Basic_class;

import java.util.StringTokenizer;

public class StringTokenizerExample1 {
	public static void main(String[] args) {
		//StringTokenizer stok = new StringTokenizer("사과 배 복숭아");
		StringTokenizer stok = new StringTokenizer("사과,배,복숭아", ",");
		while(stok.hasMoreTokens()) {
			String str = stok.nextToken();
			System.out.println(str);
		}
	}
	/*
	 * StringTokenizer class : 문자열로부터 토큰을 추출하는 기능을 가지고 있다.
	 * 토큰(token) : 문자열을 구성하는 단위(공백 문자를 기준으로 구분함)
	 * 기본적으로 공백 문자를 기준으로 토큰을 구분하나, 다른 문자를 구획문자로 사용하게 만들 수도 있다.
	 * 예) stok = new StringTokenizer("사과,배,복숭아", ","); -> ',' 를 구획문자로 지정함
	 * 하나의 문자열에서 두 종류 이상의 구획문자를 한꺼번에 사용하고 싶을 경우, 생성자의 두번째 파라미터에 그 구획문자들을 모두 포함한 문자열을 넘겨준다.
	 * 예) stok = new StringTokenizer("사과,배|복숭아", ",|"); -> ','과 '|'를 구획문자로 지정함 
	 * 구획문자 까지 토큰으로 추출 해야 한다면 생성자의 세번째 파라미터로 true 를 넘겨준다.
	 * 예) stok = new StringTokenizer("사과=10|초콜렛=3|샴페인=1", "=|", true);
	 * 객체 생성 이후 nextToken 메소드를 이용하여 문자열로부터 토큰을 추출해 낼 수 있다.
	 * 이 메소드는 문자열의 제일 앞에서부터 순서대로 토큰을 추출하기 때문에, StringTokenizer 객체를 생성하고 나서
	 * 처음으로 이 메소드를 호출하면 첫번째 토큰이 리턴되고, 두번째 호출하면 두번째 토큰이 리턴된다.
	 * 토큰을 모두 추출하고 난 다음 다시 호출하면 NoSuchElementException 이 발생한다.
	 * 이런 익셉션을 막기 위해서는 nextToken 메소드를 호출하기 전에 먼저 추출할 토큰이 남아 있는지를 확인하면 된다.
	 * 그런일은 StringTokenizer class 의 또 다른 메소드인 hasMoreTokens 를 이용해서 할 수 있다.
	 */
}
