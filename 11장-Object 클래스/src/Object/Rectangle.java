package Object;
/*
 * 직접 작성하는 클래스를 복제 가능한 클래스로 만들 수 있다.
 * 직접 작성한 클래스를 복제 가능한 클래스로 만들기 위해서는 
 * 1. Cloneable interface 를 구현하도록 만든다. 
 * 2. 이 클래스가 Object class 로 부터 상속받은 clone method 를 오버라이드 한다.
 */
public class Rectangle implements Cloneable{ //implements 키워드를 이용하여 Cloneable interface 를 구현하도록 한다.
	int width, height;
	Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	//Object class 에 선언되어 있는 clone method 를 오버라이드 한다.
	public Object clone() {
		//clone method 안에는 객체를 복제해서 리턴하는 명령문을 작성해야 한다.
		//객체를 복제하는 일은 슈퍼클래스인 Object class 의 clone method 를 호출해서 할 수 있다.
		try {
			return super.clone();
			//슈퍼클래스의 clone 메소드를 호출해서 그 결과를 리턴한다.
		}
		catch(CloneNotSupportedException e) {
			return null;
			//슈퍼클래스의 clone method 가 발생하는 익셉션을 처리해야 한다.
		}
		/*
		 * Object class 의 clone method 는 CloneNotSupportedException 을 발생 할 수 있으므로 try - catch 문으로 묶어서 작성한다.
		 */
	}
	int getArea() {
		return width * height;
	}
}
