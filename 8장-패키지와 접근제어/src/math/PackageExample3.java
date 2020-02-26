package math;
//다른 패키지에 속하는 class 를 사용하는 프로그램
//import 문을 사용하면 패키지 이름을 작성하지 않아도 외부 패키지의 클래스를 사용할 수 있다.
public class PackageExample3 {
	public static void main(String[] args) {
		geometry.polygon.Rectangle obj = new geometry.polygon.Rectangle(2, 3);
		System.out.println("넓이 = " + obj.width);
		System.out.println("높이 = " + obj.height);
		System.out.println("면적 = " + obj.getArea());
	}
}
