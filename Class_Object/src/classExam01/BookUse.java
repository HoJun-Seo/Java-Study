package classExam01;

public class BookUse {

	public static void main(String[] args) {
		
		Book book = new Book("자바", "김영한", "인프런", 2021, 12000, 5);
		book.calc();
		
		System.out.println(book.toString());
	}
}
