package System;

import java.util.Properties;
/*
 * 시스템 프로퍼티(system property) 는 자바 프로그램의 실행환경에 대한 여러가지 정보를 담는 역할을 하는 일종의 변수이다.
 * 자바 가상기계가 자바 프로그램을 시작할때 운영체제로부터 읽어와서 자동으로 설정한다.
 * 시스템 프로퍼티를 읽어오는 방법은 두 가지가 있는데 1. 설정되어 있는 모든 시스템 프로퍼티를 한꺼번에 읽어오는 방법, 2. 특정 시스템 프로퍼티만 읽어오는 방법 이 있다.
 * 모든 시스템 프로퍼티를 한꺼번에 읽어올 때는 getProperties method 를 사용한다.
 * 이 메소드는 시스템 프로퍼티를 Properties class 의 객체에 담아서 리턴하기 때문에 아래와 같은 방식으로 호출해야 한다.
 * Properties props = System.getProperties();
 * Properties class 에는 list method 가 있는데, 이 메소드는 객체에 있는 모든 프로퍼티를 파라미터로 넘겨진 출력 스트림 객체를 통해 출력하는 메소드이다.
 * 이 메소드에 System class 의 out 필드를 넘겨주면 Properties 안에 있는 모든 프로퍼티 들이 모니터로 출력된다.
 * 읽어온 시스템 프로퍼티에서 각 행은 각각 하나씩의 시스템 프로퍼티에 해당하며, 각 행에서 = 기호를 기준으로 왼쪽은 시스템 프로퍼티의 이름이고 오른쪽은 시스템 프로퍼티의 값이다.
 */
public class SystemExample5 {
	public static void main(String[] args) {
		Properties props = System.getProperties(); // 모든 시스템 프로퍼티를 읽어오는 메소드
		props.list(System.out); //가져온 시스템 프로퍼티를 모두 출력한다.
	}
}
