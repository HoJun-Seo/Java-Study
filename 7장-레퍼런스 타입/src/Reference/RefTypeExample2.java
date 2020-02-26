package Reference;

public class RefTypeExample2 {
	public static void main(String[] args) {
		Point obj = new Point(10, 20);
		System.out.printf("(%d, %d) \n", obj.x, obj.y);
		rearrange(obj);
		System.out.printf("(%d, %d) \n", obj.x, obj.y);
	}
	static void rearrange(Point point) {
		point.x = 30;
		point.y = 40;
		//파라미터 변수의 필드에 다른 값을 대입해도 같은 객체의 메모리를 가리키고 있기 때문에 main 함수에서도 값을 바꾼것이 적용된다.
	}
}
