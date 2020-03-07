package Object;

public class Circle {
	int radius;
	Circle(int radius){
		this.radius = radius;
	}
	public boolean equals(Object obj) {
		if(!(obj instanceof Circle)) return false;
		//파라미터 객체가 Circle 타입인지 검사한다.
		Circle circle = (Circle)obj;
		//파라미터 객체를 Circle 타입으로 캐스트 한다.
		if(radius == circle.radius) return true;
		else return false;
		//파라미터 객체와 객체 자신의 radius 필드 값을  비교한다.
	}
	/*
	 * 이와 같이 equals method 를 오버라이드 해도 완벽한 클래스라고 할 수 없다.
	 * Object class 의 equals method 를 오버라이드 할 때는 hashCode 라는 메소드도 같이 오버라이드 해야 하기 때문이다.
	 * hashCode method 또한 equals method 처럼 Object class 에 선언되어 있는 메소드 인데 
	 * 그 메소드의 역할과 왜  equals method 와 함께 오버라이드 해야 하는지에 대해서는 자료구조 파트에서 참조한다. 
	 */
}
