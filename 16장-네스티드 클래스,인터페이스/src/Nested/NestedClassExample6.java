package Nested;
/*
 * 정적 네스티드 클래스는 인클로징 클래스의 정적(static) 구성요소 이다. 그래서 정적 네스티드 클래스의 객체는 이너 클래스의 경우 처럼
 * 인클로징 객체와 연관 관계를 맺거나 하지 않는다.
 * 그렇기 때문에 정적 네스티드 클래스의 객체를 생성 할 때는 new 키워드 앞에 아무것도 쓸 필요가 없고, 생성자 이름 앞에 인클로징 클래스의 이름과 마침표만 써주면 된다.
 * 예) Line.Point point = new Line.Point(100, 200); - Line : 인클로징 클래스의 이름, Point : 정적 네스티드 클래스의 이름
 */
public class NestedClassExample6 {
	public static void main(String[] args) {
		Line.Point point = new Line.Point(100, 200);
		//정적 네스티드 클래스 객체의 생성
		System.out.printf("(%d, %d)", point.x, point.y);
	}
}
