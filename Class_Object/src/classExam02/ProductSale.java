package classExam02;

public class ProductSale  extends ProductInherit{
	

	private int price;//단가
	private int amount; // 수량
	private int money;// 판매금액(단가 * 수량)
	
	// 생성자를 활용하여 입력값 전달
	public ProductSale(int code, String name, String company, String date,int price, int amount) {
		// 부모생성자 호출
		super(code, name, company, date);
		this.price = price;
		this.amount = amount;
	}
	
	// 생성자를 이용하지 않고 메서드를 통해 입력값 전달
	public void Input(int code, String name, String company, String date,int price, int amount) {
		// 부모클래스 멤버변수 private선언시 메소드를 통해 전달
		setCode(code);
		setName(name);
		setCompany(company);
		setDate(date);
		
		this.price = price;
		this.amount = amount;
	}
	
	// 계산 
	public void calc() {
		money = price * amount;
	}
	public void print() {
		System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n","코드","품명","제조사","제조일자","단가","수량","판매금액");
		System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10d\t%-10d\t%-10d",getCode(), getName(), getCompany(), getDate(), price, amount, money);
	}

	// setter,getter
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}

/*
판매정보 클래스
입력: 제품코드,품명,제조사,제조일자,단가,수량
계산 : 판매금액(단가x수량)
출력 : 제품코드, 품명, 제조사,제조일자,단가,수량, 판매금액


*/