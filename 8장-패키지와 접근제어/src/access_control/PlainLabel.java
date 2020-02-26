package access_control;

public class PlainLabel implements Movable{
	int x, y;
	String str;
	PlainLabel(int x, int y, String str) {
		this.x = x;
		this.y = y;
		this.str = str;
	}
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//인터페이스로 상속받은 메소드를 구현할 때도, 메소드 오버라이딩과 접근 제어 수식간의 규칙은 동일하게 적용된다.
	//그런데 인터페이스의 경우, 구성요소에 public 키워드를 붙이지 않아도 컴파일할 때 해당 키워드가 자동으로 추가된다.
	//그렇기 때문에 인터페이스로부터 상속받은 메소드를 구현할 때는 항상 public 키워드를 붙여줘야 한다.
}
