package Serialization;
/*
 * 직접 클래스를 선언 할 때, java.io.Serializble interface 를 구현하도록 만들면 직렬화 가능 클래스가 될 수 있을까?
 * 답은 간단치 않으나, 아래의 GoodsStock class 는 해당 인터페이스를 구현하는 것만으로 직렬화 가능 클래스로 만들수 있다.
 */
public class GoodsStock implements java.io.Serializable{
	String code;
	int num;
	GoodsStock(String code, int num){
		this.code = code;
		this.num = num;
	}
	void addStock(int num) {
		this.num += num;
	}
	int subtractStock(int num) throws Exception{
		if(this.num < num)
			throw new Exception("재고가 부족합니다.");
		this.num -= num;
		return num;
	}
}
