package Nested;
/*
 * 직선을 생성하고 이동시키는 일은 Line class 의 생성자와 move method 를 호출해서 할 수 있다.
 * 직선의 끝점 위치는 Line class 의 point1, point2 필드 값을 가져다가 출력하면 된다.
 * 그런데 이 두 필드는 모두 Line class 의 정적 네스티드 클래스인 Point 타입이기 때문에 이 필드 값을 가져와서 그 타입의 변수에 대입해야 한다.
 * 인클로징 클래스 외부에서 정적 네스티드 클래스를 사용할 때는 아래와 같이 클래스 이름 앞에 인클로징 클래스의 이름과 마침표(.)를 붙여 써야 한다.
 * 예) Line.Point point = line.point1;
 * 지금까지는 이너 클래스와 크게 다르지 않으나, 인클로징 클래스 외부에서 정적 네스티드 클래스의 객체를 생성하는 방법은 이너 클래스와 완전히 다르다. - NestedClassExample6 참조
 */
public class NestedClassExample5 {
	public static void main(String[] args) {
		Line line = new Line(0, 0, 100, 100);
		line.move(10, 20);
		printPoint(line.point1);
		printPoint(line.point2);
	}
	static void printPoint(Line.Point point) {
		System.out.printf("(%d, %d) \n", point.x, point.y);
	}
}
