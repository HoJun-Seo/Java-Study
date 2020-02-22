package object_class;
//상품 재고 클래스
public class GoodsStock {
	String goodsCode; //상품 코드
	int stockNum; //재고 수량
	GoodsStock(String code, int num){ // 생성자 생성 - 객체를 생성할때 파라미터 값을 넘겨 줄 수 있다.
		//클래스와 같은 이름으로 생성하며 리턴 값이 없어야 한다.
		goodsCode = code;
		stockNum = num;
	}
	void addStock(int amount) { //재고 수량 추가 메소드
		stockNum += amount;
	}
	int subtractStock(int amount) { //재고 수량 감소 메소드
		if(stockNum < amount) return 0;
		stockNum -= amount;
		return amount;
	}
}
