package Basic_class;

public class StringBuilderExample4 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(100);
		sb.append("자바");
		System.out.println(sb + ": " + sb.capacity());
		sb.trimToSize();
		//버퍼가 저장된 문자의 수에 비해 과도하게 크면, 문자의 수에 맞는 적당한 크기로 줄이는 메소드.
		System.out.println(sb + ": " + sb.capacity());
	}
}
