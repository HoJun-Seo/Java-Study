package Basic_class;

public class StringBuilderExample3 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("푸른 산빛을");
		sb.ensureCapacity(50);
		/*
		 * 파라미터로 버퍼 크기를 입력받지만, 항상 그 크기로 버퍼를 늘리는 것이 아니라 더 크게 늘리기도 하는 메소드
		 * 파라미터로 입력된 버퍼 크기가 '원래의 버퍼 크기 * 2 + 2' 보다 작으면 '원래의 버퍼 크기 * 2 + 2'에 해당하는 크기로 버퍼를 늘린다.
		 * 파라미터로 넘겨진 버퍼 크기가 '원래의 버퍼 크기 * 2 + 2' 보다 크다면 파라미터로 주어진 크기로 버퍼를 늘린다.
		 */
		printStringBuilder(sb);
		sb.append(" 깨치고 적은 길을 걸어서 참어 떨치고 갔습니다.");
		printStringBuilder(sb);
		sb.insert(10, " 단풍나무 숲을 향하여 난");
		printStringBuilder(sb);
	}
	static void printStringBuilder(StringBuilder sb) {
		String str = sb.toString();
		int len = sb.length();
		int bufsize = sb.capacity();
		System.out.printf("%s(%d) : %d \n", str, len, bufsize);
	}
}
