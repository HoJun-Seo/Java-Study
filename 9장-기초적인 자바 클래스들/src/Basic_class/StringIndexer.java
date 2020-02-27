package Basic_class;

public class StringIndexer {
	public static void main(String[] args) {
		String str = "꽃나무는 제가 생각하는 꽃나무를" + "열심으로 생각하는 것처럼 열심으로 꽃을 피워가지고 섰소";
		System.out.println(str.indexOf('꽃'));
		System.out.println(str.indexOf('꽃', 3)); //문자열의 3번째 위치에서 시작하여 '꽃' 글자를 찾는다. - 찾은 후 해당 인덱스 값 리턴
		System.out.println(str.indexOf("꽃나무"));
		System.out.println(str.indexOf("꽃나무", 3));
		System.out.println(str.lastIndexOf('꽃')); //문자열의 끝에서 부터 검색
		System.out.println(str.lastIndexOf('꽃', 20)); //뒤에서 부터 20번째 위치에서 검색 시작 - '꽃' 글자를 찾으면 문자열의 시작위치를 기준으로한 인덱스 값 리턴
		System.out.println(str.lastIndexOf("꽃나무"));
		System.out.println(str.lastIndexOf("꽃나무", 20));
	}
}
