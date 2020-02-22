package object_class;

public class ClassExample1 {
	public static void main(String[] args) {
		GoodsStock obj; //변수 선언
		obj = new GoodsStock("52135", 1000); //객체 생성 - GoodsStock 클래스에 생성되어 있는 생성자로 인해, 객체 생성시 파라미터 값을 넘겨 줄 수 있다.
		System.out.println("상품 코드 : " + obj.goodsCode);
		System.out.println("상품 수량: " + obj.stockNum);
		obj.addStock(1000); //메소드 호출
		System.out.println("상품 코드 : " + obj.goodsCode);
		System.out.println("상품 수량: " + obj.stockNum);
	}
}
