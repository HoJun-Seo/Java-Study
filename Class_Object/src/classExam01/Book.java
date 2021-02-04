package classExam01;

public class Book {
	
	private String bookname;
	private String author;
	private String press;
	private int year;
	private int price;
	private int amount;
	
	private int money;
	
	public Book(String bookname, String author, String press, int year, int price, int amount) {
		this.bookname = bookname;
		this.author = author;
		this.press = press;
		this.year = year;
		this.price = price;
		this.amount = amount;
	}

	// 계산 : 판매수량 X 단가
	public void calc() {
		money = price * amount;
	}

	// 디버깅
	@Override
	public String toString() {
		return "Book [bookname=" + bookname + ", author=" + author + ", press=" + press + ", year=" + year + ", price="
				+ price + ", amount=" + amount + ", money=" + money + "]";
	}
}
