package DataStructure;

import java.util.Iterator;
import java.util.LinkedList;
/*
 * Iterator 를 이용한 데이터의 순차 접근
 * LinkedList 의 get method 는 데이터를 읽을 때 첫번째 데이터부터 링크를 따라가면서 순서대로 찾는다.
 * 그런데 이렇게 되면 0, 1, 2, 3... 순의 파라미터를 가지고 get method 를 호출했을 때도 매번 같은 경로를 다시 거치게 된다.
 * LinkedList class 에는 iterator method 가 있는데, 이 메소드는 Iterator 타입의 객체를 리턴하는 메소드이다.
 * 이 객체를 이용하면 앞서 찾은 데이터의 위치를 기억하고 있다가 다음번에 바로 그 다음 데이터를 읽는 방식으로 데이터를 효율적으로 찾을 수 있다.
 * Iterator<String> iterator = list.iterator(); - 타입 파라미터는 LinkedList 와 같아야 한다.
 * Iterator 객체를 얻은 다음에는 이 객체에 대해 next method 를 호출하여 LinkedList 의 데이터를 순서대로 읽어 올 수 있다.
 * String str = iterator.next(); - Iterator 를 통해 데이터를 읽어오는 메소드
 * 이 메소드는 처음 호출했을 때 리스트의 첫번째 데이터를 리턴하고, 그 다음에 호출했을 때 두번째 데이터를, 세번째 호출 했을때는 세번째 데이터를 리턴하는 방식으로 작동한다.
 * 하지만 이 메소드는 매번 첫번째 데이터부터 링크를 따라가면서 데이터를 찾는 것이 아니라, 마지막에 읽은 데이터의 위치를 기억하고 있다가 다음번에 사용하기 때문에 훨씬 더 효율적으로 작동한다.
 * next method 는 더 이상 읽을 데이터가 없으면 NoSuchElementException 을 발생하는데 이런 익셉션을 방지하려면 먼저 hashNext method 를 호출해서
 * 더 읽을 데이터가 있는지 검사해보면 된다.
 * 이 메소드는 데이터가 있을 때 true, 없을 때 false 를 리턴하기 때문에 보통 아래의 프로그램과 같은 형태의 반복문의 조건식으로 사용된다. 
 */
public class LinkedListExample3 {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("망고");
		list.add("파인애플");
		list.add("바나나");
		Iterator<String> iterator = list.iterator(); //iterator method 를 호출하여 Iterator 객체를 얻는다.
		while(iterator.hasNext()) { //hasNext method 의 리턴값이 true 인 동안,
			String str = iterator.next(); // next method 를 반복 호출한다.
			System.out.println(str); // next method 로 가져온 데이터를 처리하는 부분
		}
		//Iterator 객체를 이용하여 리스트에 있는 데이터를 순서대로 가져와서 출력한다.
	}
}
/*
 * jdk 5.0 부터 지원하는 향상된 for 문은 다음과 같은 방법으로 리스트 객체를 사용하는 것도 허용한다.
 * for(String str : list){ - String : 변수타입, str : 변수 이름, list : 리스트 객체 // 변수 타입은 리스트 객체의 타입 파라미터와 매치되어야 한다.
 * 
 * }
 * 이렇게 작성된 for 문에서는 리스트 객체로부터 얻은 Iterator 객체를 이용해서 읽어온 데이터가 반복 실행 부분을 시작하기 전에
 * 매번 str 변수에 자동으로 대입되기 때문에, iterator method 나 next, hasNext method 를 호출할 필요가 없다.
 * ArrayList class 에도 LinkedList class 의 경우와 똑같은 방법으로 Iterator 를 사용할 수 있지만, 
 * ArrayList class 의 Iterator 는 내부적으로 get method 를 호출해서 작동하기 때문에 성능의 향상을 기대 할 수 없다.
 */
