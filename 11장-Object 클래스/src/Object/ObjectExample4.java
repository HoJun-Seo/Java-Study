package Object;

public class ObjectExample4 {
	public static void main(String[] args) {
		GoodsStock obj = new GoodsStock("73527", 200);
		System.out.println(obj); //GoodsStock 객체를 System.out.println method 에 넘겨준다.
		//System.out.println method 에 obj 객체가 넘겨졌기 때문에 메소드 내부에서 간접적으로 toString method 가 호출된다.
		/*
		 * toString method 는 지금까지 자주 사용해왔던 메소드에 의해 간접적으로 호출되기도 한다.
		 * System.out.println, System.out.print 메소드에 문자열이 아닌 객체를 넘겨주면 그 메소드 안에서 간접적으로 toString 메소드가 호출된다.
		 */
	}
}
