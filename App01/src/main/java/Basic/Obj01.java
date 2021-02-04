package Basic;

class Book{
	int bookNumber;
	String booktitle;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "책 번호 : " + bookNumber
				+ " 책 제목 : " + booktitle;
	}
}

public class Obj01 {
	public static void main(String[] args) {
		Book book = new Book();
		System.out.println(book.toString());
		System.out.println(book.hashCode()); // 객체의 주소를 문자열로 표시
		
		String str1 = new String("자바");
		String str2 = new String("자바");
		
		System.out.println((str1 == str2)); // 주소 비교
		System.out.println(str1.getBytes());
		System.out.println(str2.getBytes());
		System.out.println(str1.equals(str2)); // 내용 비교
	}
}
