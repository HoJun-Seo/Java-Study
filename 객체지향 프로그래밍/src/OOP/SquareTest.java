package OOP;

public class SquareTest {
	public static void main(String[] args) {
		
		Square sq = new Square();
		
		sq.length = 4;
		
		System.out.println("한 변의 길이가 " + sq.length + "인 정사각형의 넓이 : " + sq.area());
		
	}
}

class Square{
	int length;
	
	int area() {
		return length*length;
	}
}
