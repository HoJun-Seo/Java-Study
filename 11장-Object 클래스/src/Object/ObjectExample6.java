package Object;

public class ObjectExample6 {
	public static void main(String[] args) {
		//똑같은 값을 갖는 두개의 Circle 객체를 생성한다.
		Circle obj1 = new Circle(5);
		Circle obj2 = new Circle(5);
		if(obj1.equals(obj2))
			System.out.println("같음");
		else
			System.out.println("다름");
		//두 객체를 equals method 로 비교하여 결과를 출력한다.
		/*
		 * 똑같은 값을 주었음에도 다르다는 결과가 나오는 이유는 equals method 가 두 객체를 비교할 때 객체의 필드 값이 아니라 참조값을 가지고 비교하기 때문이다.
		 * equals method 가 의미 있는 결과를 리턴하기를 원한다면 Object class 로부터 상속받은 equals method 를
		 * toString method 와 같이 오버라이드 해야 한다.
		 * equals method 를 오버라이드 할 때는 먼저 파라미터로 넘어온 객체가 클래스 자신과 같은 타입인지 부터 체크 해야 한다.
		 * 그리고 나서 그 객체를 클래스 자신의 타입으로 캐스트 한 다음에 필드 별로 비교 작업을 수행해야 한다.
		 * 같은 패키지의 Circle class 참조
		 */
	}
}
