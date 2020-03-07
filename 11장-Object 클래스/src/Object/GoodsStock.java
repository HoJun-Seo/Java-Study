package Object;

public class GoodsStock {
	String goodsCode; //상품코드
	int stockNum; //재고 수량
	GoodsStock(String goodsCode, int stockNum){
		this.goodsCode = goodsCode;
		this.stockNum = stockNum;
	}
	public String toString() {
		//(8장 참조)Object class 에 있는 toString method 가 public 으로 선언되어 있기 때문에 toString method 앞에는 위와 같이 public 키워드를 붙여줘야 한다.
		//또한 toString method 는 우리가 인식하지 못하는 곳에서 자동으로 호출되기도 하기 때문에 이 메소드를 선언 해 둘 필요가 있다.
		String str = "상품코드 : " + goodsCode + " 재고 수량 : " + stockNum;
		//상품 코드와 재고 수량을 문자열로 만들어서 리턴한다.
		return str;
	}
}
