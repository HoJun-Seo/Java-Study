package Basic_class;

public class StringBuilderExample2 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("푸른 산빛을");
		printStringBuilder(sb);
		sb.append(" 깨치고 적은 길을 걸어서 참어 떨치고 갔습니다.");
		printStringBuilder(sb);
		sb.insert(10, " 단풍나무 숲을 향하여 난");
		printStringBuilder(sb);
	}
	static void printStringBuilder(StringBuilder sb) {
		String str = sb.toString(); //버퍼의 문자열을 String 객체로 만들어서 리턴하는 메소드
		int len = sb.length(); //버퍼의 문자열 길이를 리턴하는 메소드
		int bufsize = sb.capacity(); //버퍼의 크기를 int 타입의 값으로 리턴하는 메소드
		System.out.printf("%s(%d) : %d \n", str, len, bufsize);
	}
	/*
	 * StringBuilder class 는 버퍼의 크기를 조금만 늘려도 될 때, 필요한 만큼 만 증가시키는게 아니라 
	 * 본래 버퍼 크기의 약 2배 이상으로 크기를 늘린다.
	 * 그렇게 하는 이유는 버퍼를 늘이는 작업이 새로운 메모리의 할당을 필요로 하는, 프로그램의 성능에 부담이 큰 일이기 때문에 
	 * 조금씩 자주 늘리는 것보다 한 꺼번에 넉넉히 늘리는 정책을 택한 것이다.
	 * 그런데 이런식으로 버퍼의 크기를 늘리는 방식은 불필요하게 큰 버퍼의 할당으로 인해 메모리 낭비를 초래 할 수 있다.
	 * 그렇기 때문에 StringBuilder class 를 사용할 때는 문자열이 얼마나 길어질지 예측하여
	 * 충분하면서도 과도하지 않은 버퍼 크기를 미리 할당해 두고 사용하는것이 중요하다.
	 */
}
