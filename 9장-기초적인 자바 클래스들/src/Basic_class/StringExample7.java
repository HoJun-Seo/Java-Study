package Basic_class;

public class StringExample7 {
	public static void main(String[] args) {
		String str1 = "		Let it be.		";
		String str2 = str1.trim();
		System.out.println(str2);
		System.out.println(str2.concat("Speaking words of wisdom."));
		System.out.println(str2.toUpperCase());
		System.out.println(str2.toLowerCase());
		System.out.println(str2.replace('e', 'a'));
		System.out.println(str1);
		System.out.println(str2);
		/*
		 * 위와 같이 문자열을 조작하는 메소드 들은 문자열 자체를 변경 시키는게 아니라 
		 * 문자열을 변경시킨 새로운 객체를 생성하는 것이기 때문에
		 * 문자열 조작이 빈번하게 일어나는 프로그램에서는 효율적이지 못하다.
		 * 그러니 문자열 조작이 많은 프로그램 이라면 위와 같은 문자열 조작 메소드들 보다
		 * StringBuilder class 나 StringBuffer class 를 사용하는 것이 좋다.
		 * 위의 두 클래스 들은 객체 내부에 있는 버퍼에 문자열 내용을 담아두고 거기서 조작을 하기 때문에
		 * String class 처럼 많은 객체를 생성하지 않고도 효율적으로 문자열을 조작할 수 있다.
		 */
	}
}
