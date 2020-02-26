package math;
import geometry.polygon.Rectangle; //import 선언문
public class PackageExample4 {
	public static void main(String[] args) {
		Rectangle obj = new Rectangle(2, 3); //패키지 이름 없이 클래스 이름만 가지고 사용한다.
		System.out.println("넓이 = " + obj.width);
		System.out.println("높이 = " + obj.height);
		System.out.println("면적 = " + obj.getArea());
	}
}
