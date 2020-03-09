package DataStructure;
/*
 * HashMap class 의 put, get, remove method 는 파라미터로 넘겨진 키 값을 가지고 통 번호를 계산한다.
 * 위의 메소드들이 통 번호를 계산할 때 hashCode method 를 사용하는데, 이 메소드는 키 값으로 넘겨진 객체에 대해 호출된다.
 * 예를 들어 "헤르미온느" 라는 문자열이 키로 사용되면 그 String 객체에 대해 hashCode method 가 호출된다.
 * hashCode method 는 Object class 에 선언되어 있는 메소드이다. 그래서 다른 클래스도 모두 이 메소드를 상속 받는다.
 * 이 메소드가 리턴하는 값은 대게 복잡한 int 타입 값인데, 그 값은 무작위로 생성된 값이 아니라 객체의 필드 값을 가지고 일정한 공식을 거쳐서 얻어진 값이다.
 * 그렇기 때문에 같은 필드 값을 갖는 객체에 대해 이 메소드를 호출하면 항상 같은 값이 리턴된다.
 */
public class HashCodeExample1 {
	public static void main(String[] args) {
		String obj1 = new String("헤르미온느");
		String obj2 = new String("헤르미온느");
		int hash1 = obj1.hashCode();
		int hash2 = obj2.hashCode();
		System.out.println(hash1);
		System.out.println(hash2);
		
	}
}
