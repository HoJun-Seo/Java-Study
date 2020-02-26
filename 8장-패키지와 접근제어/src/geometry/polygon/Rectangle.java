package geometry.polygon;
//class 와 class 의 구성요소 앞에 public 을 붙여주면 패키지 외부에서 해당 class 를 사용하는 것이 가능해진다.
public class Rectangle {
	public int width, height;
	public Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}
	public int getArea() {
		return width * height;
	}
}
