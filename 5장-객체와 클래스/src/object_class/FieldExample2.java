package object_class;

public class FieldExample2 {
	public static void main(String[] args) {
		Circle obj = new Circle(0.0);
		obj.radius = 5.0; //Circle 객체의 radius 필드에 값을 대입
		double area = obj.getArea();
		System.out.println(obj.radius);
		System.out.println(area);
	}
}
