package Nested;
/*
 * 정적 네스티드 클래스는 인터페이스 안에서도 선언할 수 있다.
 * 인터페이스 내부에 선언된 정적 네스티드 클래스는 해당 인터페이스를 구현하는 클래스에 상속되기 때문에 그 클래스 안에서 사용할 수 있다.
 */
public interface PlaneObject { //평면 도형 인터페이스
	Location getLocation();
	void setLocation(int x, int y);
	static class Location{ //위치 클래스
		//정적 네스티드 클래스
		int x, y;
		Location(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
