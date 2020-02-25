package Inheritance;

public class SeperateVolume implements Lendable{//단행본 클래스
	String requestNo;//청구번호
	String bookTitle;//제목
	String writer;//저자
	String borrower;//대출인
	String checkOutDate;//대출일
	byte state;//대출상태
	SeperateVolume(String requestNo, String bookTitle, String writer) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	public void checkOut(String borrower, String date) throws Exception {
		//public - interface 의 메소드를 구현할 때 반드시 써야 하는 키워드이다.
		if(state != STATE_NORMAL) throw new Exception("대출불가 : " + bookTitle); //추상 메소드에서 익셉션을 던지려면
																			//추상 메소드를 선언한 인터페이스 코드에도 throw 절을 추가해줘야 한다.
		this.borrower = borrower;
		this.checkOutDate = date;
		this.state = STATE_BORROWED;
		System.out.println("*" + bookTitle + "이(가) 대출되었습니다.");
		System.out.println("대출인 : " + borrower);
		System.out.println("대출일 : " + date + "\n");
	}
	public void checkIn() {
		this.borrower = null;
		this.checkOutDate = null;
		this.state = STATE_NORMAL;
		System.out.println("*" + bookTitle + "이(가) 반납되었습니다.\n");
	}
}
