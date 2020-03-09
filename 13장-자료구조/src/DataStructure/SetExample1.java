package DataStructure;

import java.util.HashSet;
import java.util.Iterator;
/*
 * HashSet class 는 집합으로 사용할 수 있는 클래스이다.
 * HashSet 에 데이터를 저장할 때는 add method 를 사용해야 한다.
 * 그런데 이 add method 는 이미 있는 데이터와 같은 값을 파라미터로 넘겨주면 메소드 호출 후에도 기존의 상태를 그대로 유지한다. - 이미 있는 데이터를 저장하면 집합에 변동이 일어나지 않음
 * HashSet 에 있는 데이터의 수를 알고 싶을 때는 size method 를 호출하면 된다.
 * 그런데 집합에 있는 데이터에는 순서가 없다. 그렇기 때문에 HashSet 에 있는 데이터를 순서대로 읽어오거나, 특정 위치의 데이터를 읽어올 수 있는 방법은 없다.
 * 하지만 집합에 있는 데이터를 모두 읽어 올 수 있는 방법은 있다.
 * HashSet class 에는 LinkedList class 에 있는 것과 같은 iterator method 가 있는데, 이 메소드를 이용하면 집합에 있는 모든 데이터를 읽어 올 수 있다.
 */
public class SetExample1 {
	public static void main(String[] args) {
		HashSet<String> set= new HashSet<String>();
		//집합으로 사용할 HashSet 객체를 생성한다.
		set.add("자바");
		set.add("카푸치노");
		set.add("에스프레소");
		set.add("자바");
		//집합에 데이터를 저장한다.
		System.out.println("저장된 데이터의 수 = " + set.size());
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
			//집합에 있는 모든 데이터를 가져와서 출력한다.
		}
	}
}
/*
 * 이 밖에도 HashSet class 에는 집합에 특정한 데이터가 있는지 확인하는 contains method
 * 특정 데이터를 삭제하는 remove method, 집합에 있는 모든 데이터를 삭제하고 집합을 비우는 clear method 가 있다.
 * 이런 메소드들에 대한 자세한 설명은 API 규격서를 참조 할것.
 */