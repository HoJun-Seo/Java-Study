package Serialization;

public class GoodsInfo {
	String code;
	String name;
	int price;
	GoodsInfo(){
		/*
		 * 자바의 역직렬화 매커니즘에 따르면 객체가 역직렬화 될 때는 직렬화 가능 클래스 자체의 생성자는 호출되지 않지만(BookInfo),
		 * 직렬화가 불가능한 가장 가까운 슈퍼 클래스의 no-arg constructor(파라미터 없는 생성자)가 자동으로 호출된다.
		 * 그런데 해당 슈퍼 클래스에서 no-arg constructor 가  존재하지 않으면 객체을 역직렬화 할때 readObject method 에서 IOException 이 발생하게 된다.
		 * 따라서 익셉션이 발생하지 않도록 하기 위해 슈퍼 클래스인 GoodsInfo class 에 no-arg constructor 를 추가해준다.
		 */
	}
	GoodsInfo(String code, String name, int price){
		this.code = code;
		this.name = name;
		this.price = price;
	}
}
