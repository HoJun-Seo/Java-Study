package Basic_class;

public class StringExample1 {
	public static void main(String[] args) {
		String str = "자바 커피";
		int len = str.length(); //문자열의 길이를 리턴하는 메소드
		for(int cnt = 0; cnt < len; cnt++) {
			char ch = str.charAt(cnt);//주어진 인덱스 위치의 문자를 리턴하는 메소드
			System.out.println(ch);
		}
	}
}
