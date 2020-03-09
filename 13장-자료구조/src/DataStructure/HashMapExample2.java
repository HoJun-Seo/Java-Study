package DataStructure;

import java.util.HashMap;
/*
 * HashMap class 의 put, get, remove method 는 키 값을 하나만 받을 수 있다. 그렇기 때문에 둘 이상의 값으로 키를 구성하기 위해서는
 * 우리가 직접 만든 클래스를 선언해서 키로 사용해야 한다.
 * 여기서 put, get, remove method는 해쉬 테이블에 있는 통 번호를 계산할 때 키 값에 대해 hashCode method 를 호출한다.
 * 그렇기 때문에 같은 키 값에 대해 hashCode method 를 호출하면 항상 같은 값이 리턴되어야 하지만, Name class 에서 equals method 와 hashCode method 를 오버라이드 하지 않으면
 * 같은 키 값에 대해 항상 같은 키 값을 리턴하지 않게 된다.
 * 그런 결과가 나오는 이유는 hashCode method 를 Name class 에서 오버라이드 하지 않게 되면 Name class 는 Object class 로 부터 상속받은 hashCode method 를 그대로 사용하기 때문이다.
 * Object class 의 hashCode method 는 대개의 경우 서로 다른 객체에 대해 다른 값을 리턴하기 때문이다.(참조값이 서로 다르기 때문)
 * hashCode method 오버라이드 방법은 Name class 참조
 * 또한 put, get, remove method 는 통 번호를 계산하여 데이터가 있는 통을 찾고 난 다음, 그 통안에 있는 여러 데이터들 중에
 * 똑같은 키 값을 갖는 데이터를 찾기 위해 equals method 를 사용한다.
 * 그런데 Name class 는 Object class 의 equals method 를 그대로 상속받기 때문에, 필드 값이 같더라도 false 를 리턴할 수 있다 - 11장 참조
 * equals method 오버라이드 방법은 Name class 참조
 */
public class HashMapExample2 {
	public static void main(String[] args) {
		HashMap<Name, Integer> hashtable = new HashMap<Name, Integer>();
		hashtable.put(new Name("해리", "포터"), new Integer(95));
		hashtable.put(new Name("헤르미온느", "그레인져"), new Integer(100));
		hashtable.put(new Name("론", "위즐리"), new Integer(85));
		hashtable.put(new Name("드레이코", "말포이"), new Integer(93));
		hashtable.put(new Name("네빌", "롱버텀"), new Integer(70));
		Integer num = hashtable.get(new Name("헤르미온느", "그레인져"));
		System.out.println("헤르미온느 그레인져의 성적은? " + num);
	}
}
