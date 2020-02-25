package Inheritance;

public class Rectangle implements Transformable{
	int x, y, width, height;
	Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	//다른 인터페이스를 상속 받는 인터페이스를 구현하는 클래스는
	//구현 하는 인터페이스가 가지고 있는 메소드 외에도 해당 인터페이스가 상속받고 있는 인터페이스의 메소드 또한 구현해야 한다.
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void moveBy(int xOffset, int yOffset) {
		this.x += xOffset;
		this.y += yOffset;
	}
}
