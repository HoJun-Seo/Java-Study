package Nested;
/*
 * 인클로징 클래스 외부에서 이너 클래스 객체를 생성할 수 있다. - new 키워드 앞에 아래와 같이 인클로징 객체의 이름과 마침표롤 써주어야 한다.
 * 예) Cart.Item item = cart.new Item("꽃다발", 1, 50000); - cart : 인클로징 객체, new ~ : 이너 클래스의 생성자 호출
 * new 키워드 앞에 인클로징 객체의 이름을 써줘야 하는 이유는 이너 클래스 객체와 인클로징 클래스 객체 사이에 명시적으로 나타나지는 않지만 서로 연관 관계가 있기 때문이다.
 * 이너 클래스 객체가 생성되는 시점에 연관 관계가 맺어지는데, new 키워드 앞에 표시된 인클로징 객체가 그 대상이 된다.
 * 그러나 인클로징 클래스 안에서 이너 클래스 객체를 생성할 때는 그 명령문이 속하는 인클로징 객체와 자동으로 연관 관계가 맺어지기 때문에 
 * new 키워드 앞에 인클로징 객체의 이름을 써 줄 필요가 없다.
 * 연관 관계가 하는 역할은 PiggyBank class 와 NestedClassExample3 class 에서 분명하게 드러난다.
 */
public class NestedClassExample1 {
	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.addItem("초콜렛", 3, 1000);
		cart.addItem("케이크", 1, 25000);
		cart.addItem("샴페인", 1, 7000);
		//장바구니를 생성해서 세 개의 상품 항목을 추가한다.
		Cart.Item item = cart.new Item("꽃다발", 1, 50000);
		cart.list.add(item);
		//상품 항목 객체를 생성해서 장바구니에 추가한다.
		printCart(cart);
	}
	static void printCart(Cart cart) {
		int num = cart.getItemNum();
		System.out.println("              상품명   수량       단가              금액");
		System.out.println("-------------------------------");
		for(int cnt = 0; cnt < num; cnt++) {
			Cart.Item item = cart.getItem(cnt);
			System.out.printf("%3d %5s %5d %7d %7d \n", cnt + 1, item.name, item.num, item.unitPrice, item.getPrice());
		}
		//장바구니에 있는 상품 항목을 순서대로 가져와서 출력한다.
		System.out.println("-------------------------------");
		System.out.printf("              총계                              %10d\n", cart.getTotalPrice());
	}
}
