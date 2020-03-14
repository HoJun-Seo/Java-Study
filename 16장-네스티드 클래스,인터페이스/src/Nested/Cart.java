package Nested;

import java.util.ArrayList;
/*
 * 네스티드 클래스,인터페이스 : 클래스나 인터페이스 안에 선언되어 다른 클래스나 인터페이스 와는 다르게 선언된 인클로징 클래스, 인터페이스에 종속적인 클래스 또는 인터페이스   
 * 네스티드 클래스의 종류 : 정적 네스티드 클래스(static nested class), 이너 클래스(inner class), 로컬 이너 클래스(local inner class)
 * 현재 프로그램과 같은 이너 클래스의 경우 클래스 안에 필드, 메소드 와 뚝같은 수준으로 선언된 static 키워드가 붙지 않은 네스티드 클래스를 말한다.
 * 이너 클래스는 클래스 안에만 선언할 수 있고, 인터페이스 안에는 선언 할 수 없다.
 * 이너 클래스를 포함하는 클래스를 컴파일하면 인클로징 클래스와 이너 클래스의 클래스 파일이 별도로 생성된다.
 * 해당 프로그램과 같이 장바구니 클래스를 만들때 상품 항목 클래스에서 상품명, 수량, 단가, 금액과 같은 필드들은 반복되는 항목이기 때문에 하나로 묶어서 장바구니 클래스 안에 이너 클래스로 선언하는 것이 좋다.
 */
public class Cart { //장바구니 클래스
	ArrayList<Item> list = new ArrayList<Item>();
	void addItem(String name, int num, int unitPrice) {// 장바구니 클래스에 상품 항목을 추가하는 메소드
		list.add(new Item(name, num, unitPrice)); //이너 클래스의 생성자 호출
		//ArrayList 의 method 를 이용한다.
		//이너 클래스의 객체를 생성함에 있어 인클로징 객체와 자동으로 연관 관계가 맺어지기 때문에 new 키워드 앞에 인클로징 객체의 이름을 써 줄 필요가 없다.
	}
	void removeItem(int index) {
		list.remove(index);
	}
	int getItemNum() {
		return list.size();
	}
	Item getItem(int index) { //장바구니에 있는 상품 항목을 가져오는 메소드
		//리턴 타입이 이너 클래스인 Item 타입이기 때문에, 리턴 값을 받는 변수도 이 타입으로 선언해야 한다.
		//인클로징 클래스 외부에서 이너 클래스를 사용할 때는 이너 클래스의 이름 앞에 인클로징 클래스의 이름과 마침표(.) 를 붙여줘야 한다.
		//예) Cart.Item item = cart.getItem(cnt);
		//이렇게 선언된 변수에 이너 클래스의 객체를 대입하고 나면 다른 객체와 똑같은 방법으로 사용할 수 있다.
		//예) String str = item.name; - item : 이너 클래스 객체, name : 필드 이름
		//이너 클래스의 메소드도 일반 클래스의 메소드와 똑같은 방법으로 호출 될 수 있다.
		//예) int num = item.getPrice(); - item : 이너 클래스 객체, getPrice() : 메소드 이름
		return list.get(index);
	}
	int getTotalPrice() {
		int total = 0;
		for(Item item : list)
			total += item.getPrice(); //이너 클래스의 메소드 호출
		return total;
	}
	void changeItemNumber(int index, int num) {
		Item item = list.get(index);
		item.num = num;
	}
	class Item{ //상품 항목 클래스 - 이너 클래스 선언
		String name;
		int num;
		int unitPrice;
		Item(String name, int num, int unitPrice){
			this.name = name;
			this.num = num;
			this.unitPrice = unitPrice;
		}
		int getPrice() {
			return num * unitPrice;
		}
	}
}
