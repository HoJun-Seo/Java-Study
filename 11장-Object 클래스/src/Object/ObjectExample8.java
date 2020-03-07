package Object;

public class ObjectExample8 {
	public static void main(String[] args) {
		Rectangle obj1 = new Rectangle(10, 20); //Rectangle 객체를 생성한다.
		Rectangle obj2 = (Rectangle)obj1.clone();//clone method 로 Rectangle 객체를 복제한다.
		System.out.println("obj1 = " + obj1.width + "x" + obj1.height);
		System.out.println("obj2 = " + obj2.width + "x" + obj2.height);
		//원본 객체와 복제 객체의 값을 출력한다.
	}
}
