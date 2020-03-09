package DataStructure;

public class Name {
	String firstName;
	String lastName;
	Name(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public boolean equals(Object obj) {
		if(!(obj instanceof Name))
			return false;
		Name name = (Name)obj;
		if(firstName.equals(name.firstName) && lastName.equals(name.lastName))
			return true;
		else
			return false;
	}
	//equals method 오버라이드 - Object class 에서 상속받는 equals method 의 단점을 보완한다. - 필드 값이 같더라도 false 를 리턴하는 경우를 보완한다.
	public int hashCode() {
		return firstName.hashCode() + lastName.hashCode();
		/*
		 * 서로 다른 객체이더라도 같은 필드 값을 갖는 객체이면 같은 값을 리턴하도록 만든다.
		 * 필드 값에 따라 여러가지 해쉬 코드를 리턴하도롣 만든다. - 키를 이용한 빠른 검색이라는 해쉬 테이블의 이점을 활용하게 위함
		 * 가장 바람직한 hashCode method 는 int 타입의 표현범위 내에서 고른 분포의 값을 리턴하도록 만드는 메소드이다.
		 * Name class 의 경우에는 그렇게 하기 위해선 복잡한 사칙연산과 비트 연산을 구사할 필요가 있지만
		 * firstName 필드와 lastName 필드의 hashCode method 를 활용하면 간단하게 문제를 해결 할 수 있다.
		 * return firstName.hashCode() + lastName.hashCode();
		 * 위와 같이 작성하면 String 타입 필드의 hashCode method 를 가지고 리턴값을 계산하여 좀 더 고른 분포를 갖는 해쉬 코드를 만들 수 있다.
		 * firstName 필드와 lastName 필드에 대해서 hashCode method 를 호출하면 String class 의 hashCode method 가 호출되는데
		 * 이 메소드는  int 타입의 값을 고르게 리턴하도록 만들어져 있다. 그렇기 때문에 이 메소드의 리턴 값을 더한 값도 고른 분포를 갖는 int 값이 된다.
		 */
	}
}
