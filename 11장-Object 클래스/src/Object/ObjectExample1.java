package Object;

import java.io.File;
/*
 * Object class 는 자바의 모든 클래스들이 공통적으로 갖는 특성들을 추출하여 만들어진 클래스이다. - Object class 를 제외한 다른 모든 클래스들은 Object class 를 상속받는다.
 * 모든 클래스는 Object class 를 상속 받으나 클래스 선언 시 extends 절을 쓰지 않을 경우, 그 클래스는 자바 컴파일러가 컴파일 하는 과정에
 * 자동으로 Object class 의 서브 클래스로 만든다. 그렇기 때문에 Object class 를 제외한 자바의 모든 클래스들은 직접 또는 간접으로 Object class의 서브 클래스가 된다.
 * Object class 에는 몇몇 메소드 들이 선언되어 있는데, 그 메소드들은 자바의 다른 모든 클래스 들이 가져야 하는 기능이고, 실제로 자바의 다른 모든 클래스 들이 상속 받는다.
 * Object class 자체에는 어떤 특별한 기능도 없기 때문에 우리가 Object 객체를 직접 만들어 쓸 일은 거의 없다.
 * 하지만 이 클래스가 가지고 있는 메소드는 자바의 다른 모든 클래스 들이 상속 받기 때문에 반드시 알아 두어야 한다.
 * 예) 9장에서 사용한 equals method 는 Object class 에 선언되어 있는 메소드 이다.
 */
public class ObjectExample1 {
	public static void main(String[] args) {
		File file = new File("C:\\뻐꾸기"); //File 객체를 생성
		String str = file.toString(); //File 객체에 대해 toString method 를 호출한다.
		/*
		 * toString method : 객체가 가지고 있는 값을 문자열로 만들어서 리턴하는 메소드
		 * 파라미터를 받지 않고 리턴 타입이 String 이기 때문에 아래와 같은 방법으로 호출 할 수 있다.
		 * String str = obj.toString(); - obj 객체가 가진 값을 문자열로 만들어서 리턴하는 메소드
		 * 이 메소드는 Object class 에 선언되어 있기 때문에 다른 모든 클래스 들도 이 메소드를 상속 받는다. - 자바의 모든 객체에서 이 메소드를 호출 할 수 있다.
		 * 10장에서 배웠던 File class 의 객체에도 이 메소드를 호출 할 수 있다.
		 */
		System.out.println(str);
	}
}
