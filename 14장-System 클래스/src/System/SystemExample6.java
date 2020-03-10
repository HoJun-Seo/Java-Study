package System;
/*
 * 특정 시스템 프로퍼티를 읽어오는 방법
 * 특정 시스템 프로퍼티를 읽어오기 위해서는 System class 의 getProperty method 를 이용한다.
 * 이 메소드는 시스템 프로퍼티의 이름을 파라미터로 받고, 그 시스템 프로퍼티의 값을 문자열로 리턴한다.
 * 예를 들어 user.dir 시스템 프로퍼티의 값은 아래의 프로그램을 통해 구할수 있으며, 출력되는 값은 현재 프로그램이 실행되고 있는 디렉토리를 의미한다.
 */
public class SystemExample6 {
	public static void main(String[] args) {
		String str = System.getProperty("user.dir");
		System.out.println(str);
	}
}
