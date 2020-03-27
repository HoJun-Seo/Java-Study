package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * JDBC 를 이용한 프로그램 작성하기
 * 파일에 데이터를 읽고 쓸 때 단계적인 과정이 있듯이, 데이터베이스 에 데이터를 넣고 꺼낼 때도 단계적인 과정이 있다. 모두 4단계로 구성된다.
 * 첫 번째 단계에는 JDBC 드라이버를 자바 가상 기계 안으로 읽어들여야 한다. - JDBC 드라이버를 로드한다.
 * 두 번째 단계에는 데이터베이스에 연결을 해야 한다.
 * 데이터베이스에 연결한 다음에는 데이터베이스에 데이터를 읽고 쓸 수 있다.
 * 데이터베이스를 모두 사용했으면 프로그램을 끝내기 전에 데이터베이스 와의 연결을 끊어야 한다. - 아주 중요한 단계(대부분의 데이터베이스가 동시에 맺을 수 있는 연결의 수를 한정 짓고 있기 때문이다.)
 * 1. JDBC 드라이버를 로드한다 -> 2. DB에 연결한다. -> 3. DB에 데이터를 읽거나 쓴다.(반복 가능) -> 4. DB 연결을 끊는다.
 * 네 단계의 과정 중 데이터베이스에 데이터를 읽고 쓰는 부분은 프로그램 마다 다르기 때문에 세 번째 단계를 제외한 나머지 단계의 프로그래밍 방법을 학습한다.
 * JDBC 드라이버를 로드하기 위해서는 먼저 JDBC 드라이버의 중심이 되는 클래스의 이름을 알아야 한다, 해당 클래스의 이름은 JDBC 드라이버와 함께 제공되는 문서를 통해 확인할 수 있다.(connector-j.html 등)
 * JDBC 드라이버의 클래스 이름을 확인 한 다음에는 그 이름을 가지고 JDBC 드라이버를 로드할 수 있다. 그런 일은 java.lang.Class class 의 정적 메소드인 forName method 를 호출해서 할 수 있는데,
 * 이 메소드의 본래 기능은 주어진 클래스 이름에 해당하는 클래스 정보를 찾아서 리턴하는 것이지만 그 과정에서 클래스 파일을 자바 가상 기계 안으로 읽어들이기 때문이다.
 * Class.forName("com.mysql.cj.jdbc.Driver"); - com.mysql.cj.jdbc.Driver : JDBC 드라이버의 클래스 이름
 * 드라이버를 로드한 다음에는 데이터베이스와 연결을 맺어야 한다. 그렇게 하기 위해서는 해당 데이터베이스의 URL 을 알아야 하는데, 그 포맷은 우리가 홈페이지를 조회할 때 사용하는 일반적인 URL 포맷과는 다르다.
 * 아래는 데이터베이스 URL 의 예이다.
 * jdbc:mysql://localhost(또는 데이터베이스가 있는 해당 ip의 주소):3306/malldb
 * jdbc : 프로토콜, mysql : 서브 프로토콜, localhost:3306/malldb : 서브 네임(subname, //IP 주소:포트 번호/DB이름)
 * 이 URL 의 처음에 있는 jdbc 는 홈페이지를 조회할 때 사용하는 URL 의 http 처럼 일종의 프로토콜 이름이다. 이 프로토콜에는 JDBC 와 관계형 DBMS 가 통신하는데 필요한 일반적인 규칙들이 정의되어 있다.
 * 그런데 이런 통신의 상세 규칙은 DBMS 제품마다 조금씩 다를 수 있다. 그래서 DBMS 제품마다 이런 통신의 상세 규칙을 정의해서 서브 프로토콜로 만들어 놓고 있는데, 위에서 사용한 mysql 도 바로 그런 서브 프로토콜의 이름이다.
 * 데이터베이스 URL 의 마지막에 있는 서브 네임은 네트워크 상에서 작동중인 수많은 컴퓨터 중에서 특정 데이터베이스 서버의 특정 데이터베이스를 찾는 데 사용된다.
 * 예를 들어 위에서 사용된 서브네임은 IP 주소가 localhost(127.0.0.1 - 프로그램이 실행되고 있는 컴퓨터 자기 자신의 ip 주소를 지정함)인 컴퓨터에서 3306 포트를 열어놓고 있는 데이터베이스 서버의  malldb 라는 이름의 데이터베이스를 가리킨다.
 */
public class JDBCExample1 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //1단계 : JDBC 드라이버를 로드한다.
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "6659");
			//2단계 : DB에 연결한다.
	//malldb 뒤에 붙은 ?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC 는
	//MYSQL 타임존의 시간표현 포맷이 달라져서 connector 에서 인식을 하지 못하는 문제를 해결하기 위해 추가해주는 라인이다.
			System.out.println("데이터베이스에 접속했습니다."); //3단계는 메시지 출력문으로 대체한다.
			conn.close(); //4단계 : DB 연결을 끊는다.
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
/*
 * 이렇게 만든 데이터베이스의 URL 을 가지고 java.sql.DriverManager class 의 정적 메소드인 getConnection method 를 호출하면 데이터베이스에 연결 할 수 있다.
 * 그런데 이 메소드는 데이터베이스 연결에 필요한 사용자 ID와 패스워드도 파라미터로 받는다.
 * 예를 들어 malldb 로 연결할 때 사용할 사용자 ID가 richman 이고 패스워드가 money 이면 아래와 같은 방법으로 이 메소드를 호출해야 한다.
 * Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb", "richman", "money");
 * jdbc:mysql://localhost:3306/malldb : 데이버베이스 URL
 * richman : 사용자 ID, money : 패스워드
 * getConnection method 는 데이버베이스와 연결에 성공하면 그 결과로 Connection 타입의 객체를 리턴한다.
 * 이 타입은 java.sql 패키지에 속하는 인터페이스 인데, 이 인터페이스에는 데이터베이스 사용에 필요한 여러가지 메소드들이 선언되어 있다.
 * 하지만 지금 여기서 이 객체를 이용해서 해야할 일은 오로지 데이터베이스와 맺었던 연결을 끊는 것 뿐이다. 그런일은 아래와 같이 close method 를 호출해서 할 수 있다.
 * conn.close(); - 데이터베이스로의 연결을 끊는 메소드
 */
