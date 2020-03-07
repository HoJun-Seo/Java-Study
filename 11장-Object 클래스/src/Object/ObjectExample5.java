package Object;

import java.util.GregorianCalendar;
/*
 * equals method 는 객체가 가지고 있는 값을 비교하는 데 사용되는 메소드이다.
 * 문자열을 비교하기 위해서도 equals method 가 쓰일 수 있지만, 이 메소드는 Object class 에 선언되어 있기 때문에 
 * 문자열이 아닌 객체에 대해서도 모두 사용할 수 있다.
 * 사용법 : obj1.equals(obj2) - obj1 객체와 obj2 객체의 값을 비교한다.
 * 두 객체의 값이 같을 때 true, 다를 때 false 를 리턴한다.
 */
public class ObjectExample5 {
	public static void main(String[] args) {
		//GregorianCalendar 객체를 equals method 로 비교하는 프로그램
		//똑같은 값을 갖는 두 개의 객체를 생성한다.
		GregorianCalendar obj1 = new GregorianCalendar(2007, 0, 1);
		GregorianCalendar obj2 = new GregorianCalendar(2007, 0, 1);
		if(obj1.equals(obj2))
			System.out.println("같음");
		else
			System.out.println("다름");
		//두 객체의 값을 equals method 로 비교하여 결과를 출력한다.
	}
}
