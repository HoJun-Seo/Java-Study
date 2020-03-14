package Nested;
//PlaneObject interface 로부터 상속받은 Location class 를 마치 Rectangle class 자신의 정적 네스티드 클래스인 것처럼 사용한다.
public class Rectangle implements PlaneObject{ //사각형 클래스
	Location location;
	int width, height;
	Rectangle(int x, int y, int width, int height){
		this.location = new Location(x, y); //PlaneObject interface 로부터 상속받은 정적 네스티드 클래스의 생성자 호출
		this.width = width;
		this.height = height;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(int x, int y) {
		location.x = x;
		location.y = y;
		//정적 네스티드 클래스 필드의 사용
	}
}
