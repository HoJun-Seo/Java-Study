package object_class;
//필드의 선언
public class Circle {
	double radius; //필드 - 같은 클래스 내에서라면 순서에 상관없이 생성자나 메소드 안에서 얼마든지 사용할 수 있다.(클래스 외부에서도 사용 가능하다. - 객체 생성)
	//private double radius; - private 키워드 : 외부 클래스 접근제어(해당 필드를 선언된 클래스 내부에서만 사용 가능하게함) - 객체 정보 은닉 개념
	Circle(double radius){ //생성자
		this.radius = radius;
	}
	double getArea() { //메소드
		double area;
		area = radius * radius * 3.14;
		return area;
	}
}
