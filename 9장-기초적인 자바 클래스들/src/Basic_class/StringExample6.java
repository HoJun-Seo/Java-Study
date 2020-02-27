package Basic_class;

public class StringExample6 {
	public static void main(String[] args) {
		String str = "뇌를 자극하는 자바";
		System.out.println(str.substring(3)); //str.substring(beginIndex)
										//부분 문자열 함수 - beginIndex 부터 문자열의 끝까지 출력
		System.out.println(str.substring(3, 7)); //str.substring(beginIndex, endIndex)
										//부분 문자열 함수 - beginIndex 부터 endIndex - 1 까지의 부분 문자열을 출력
	}
}
