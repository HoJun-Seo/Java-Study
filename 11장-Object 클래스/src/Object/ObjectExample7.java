package Object;

import java.util.GregorianCalendar;
/*
 * clone method 는 객체를 복제하는 기능의 메소드이다. - 이 메소드를 사용하면 똑같은 값을 갖는 객체를 하나 더 만들 수 있다.
 * 그런데 이 메소드는 Object class 에 선언되어 있기는 하지만, 모든 클래스에 대해 호출 할 수 있는 것은 아니다.
 * 이 메소드는 복제 가능한 클래스에 대해서만 호출 할 수 있다. - clone method 를 이용해 복제할 수 있느냐 없느냐 는 그 객체를 생성하는데 사용한 클래스가
 * Cloneable interface 를 구현하는지 아닌지에 달려있다.(API 규격서 참조)
 * 이 인터페이스는 java.lang package 에 속하는데 이름에서 알 수 있듯이 복제(clone) 가 가능(able) 한지 아닌지 구분하는 역할을 한다.
 * clone method 는 자기 자신을 복제하는 메소드이기 때문에, 이 메소드가 리턴하는 값은 메소드를 호출하는 데 사용한 객체와 똑같은 타입의 객체이다.
 * 하지만 이 메소드의 리턴 타입은 Object 타입으로 선언되어 있기 때문에 이 메소드가 리턴하는 객체를 그 타입에 맞게 사용하려면 캐스트 연산을 해야한다.
 * 예) GregorianCalendar obj2 = (GregorianCalendar)obj1.clone();
 * - clone method 의 리턴 값을 GregorianCalendar 타입으로 캐스트 한 후, GregorianCalendar 타입의 변수에 대입한다.
 */
public class ObjectExample7 {
	public static void main(String[] args) {
		GregorianCalendar obj1 = new GregorianCalendar(2007, 0, 1);
		//객체를 생성한다.
		GregorianCalendar obj2 = (GregorianCalendar)obj1.clone();
		//clone method 로 객체를 복제한다.
		System.out.printf("%tF \n", obj1);
		System.out.printf("%tF \n", obj2);
		//원본 객체와 복제 객체의 값을 출력한다.
	}
}
