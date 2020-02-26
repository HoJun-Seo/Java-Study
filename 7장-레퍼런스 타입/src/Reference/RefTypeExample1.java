package Reference;

public class RefTypeExample1 {
	public static void main(String[] args) {
		Point obj1 = new Point(10,20);
		Point obj2 = obj1; //하나의 객체를 생성하여 두 개의 변수에 대입한다.
		//같은 Point 객체를 가리키고 있기 때문에 값의 대입및 변환이 가능하다.
		System.out.printf("obj1 = (%d, %d) \n", obj1.x, obj1.y);
		System.out.printf("obj1 = (%d, %d) \n", obj2.x, obj2.y);
		obj2.x = 30; //obj2 의  x 필드에 다른 값 대입, obj1.x 의 값도 함께 변한다.(같은 객체의 메모리를 가리키고 있기 때문)
		System.out.printf("obj1 = (%d, %d) \n", obj1.x, obj1.y);
		System.out.printf("obj1 = (%d, %d) \n", obj2.x, obj2.y);
	}
}
