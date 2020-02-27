package Basic_class;

public class StringBuilderExample1 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("역사를 하노라고 맨땅을 파다가");
		System.out.println(sb);
		System.out.println(sb.append(" 커다란 고인돌을 끄집어 내어놓고 보니")); //문자열 뒤에 str을 덧붙임
		System.out.println(sb.insert(26, "하나")); //문자열의 offset 위치에 str 을 삽입
		System.out.println(sb.delete(21, 23)); // start 부터 end - 1 까지 부분 문자열을 삭제
		System.out.println(sb.deleteCharAt(9)); //index 위치에 있는 하나의 문자를 삭제
		/*
		 * 각 메소드들의 return 값은 새로운 StringBuilder 객체가 아니라 기존 StringBuilder 객체에 대한 참조값일 뿐이다.
		 * StringBuilder class 는 String class 와는 달리 문자열을 조작하면서 새로운 객체를 생성하지 않기 때문이다.
		 * StringBuilder class 의 생성자 중에는 문자열을 파라미터로 받는 생성자도 있고, 정수를 파라미터로 받는 생성자도 있다.
		 * 문자열 파라미터를 받는 생성자는 StringBuilder 객체안에 문자열의 길이 + 16 크기의 버퍼를 생성하고 그 안에 문자열을 저장한다.
		 * 정수를 파라미터로 받는 생성자는 그 파라미터의 크기 만큼 비어있는 버퍼를 생성한다. - 버퍼의 크기 : 버퍼에 저장될 수 있는 문자의 수
		 * sb1 = new StringBuilder("Hello"); -> 크기가 21(5 + 16)인 버퍼 생성
		 * sb2 = new StringBuilder(100); -> 크기가 100 인 버퍼 생성
		 * StringBuilder 객체를 생성하는 시점에 저장해 둘 문자열도 없고 버퍼의 크기도 예측할 수 없다면
		 * 파라미터 없는 생성자를 가지고 StringBuilder 객체를 생성하면 된다. -> 디폴트로 크기가 16인 버퍼가 생성된다.
		 * sb3 = new StringBuilder(); -> 크기가 16인 버퍼 생성
		 * 위와 같이 생성된 버퍼들은 문자열이 길어지면 자동으로 그 크기가 늘어난다.
		 * 위의 코드에서도 마찬가지로 append 메소드를 통해 문자열의 길이가 기존에 생성되었던 크기인 33 을 넘어섰음에도
		 * 버퍼의 크기가 자동으로 늘어났기 때문에 아무런 문제가 생기지 않았다.
		 */
	}
}
