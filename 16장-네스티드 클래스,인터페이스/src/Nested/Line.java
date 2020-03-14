package Nested;
/*
 * 필드, 메소드와 동일 수준으로 선언된 네스티드 클래스 중에서 static 키워드가 붙은 네스티드 클래스를 정적 네스티드 클래스(static nested class) 라고 한다.
 * 정적 네스티드 클래스를 선언하는 방법은 클래스 선언 앞에 static 키워드를 붙인다는 점을 제외하면 이너 클래스와 동일하다.
 */
public class Line {
	Point point1, point2;
	Line(int x1, int y1, int x2, int y2){
		point1 = new Point(x1, y1);
		point2 = new Point(x2, y2);
		//정적 네스티드 클래스의 생성자 호출
	}
	void move(int offsetX, int offsetY) {
		point1.x += offsetX;
		point1.y += offsetY;
		point2.x += offsetX;
		point2.y += offsetY;
		//정적 네스티드 클래스의 필드 사용
	}
	static class Point{ //점 클래스
		//정적 네스티드 클래스
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
