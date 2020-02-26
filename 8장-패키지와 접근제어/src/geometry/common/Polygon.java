package geometry.common;
//protected 키워드가 붙은 구성요소는 같은 패키지 안에서는 자유롭게 사용할 수 있지만
//다른 패키지에서는 서브 클래스 안에서만 사용이 가능하다.
public class Polygon {
	protected int x[]; //꼭지점의 x 좌표
	protected int y[]; //꼭지점의 y 좌표
	protected Polygon(int vertexNum) {
		x = new int[vertexNum];
		y = new int[vertexNum];
	}
	protected void setPoint(int index, int x, int y) {
		this.x[index] = x;
		this.y[index] = y;
	}
}
