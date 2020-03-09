package DataStructure;

import java.util.LinkedList;
/*
 * LinkedList class 의 기본적인 사용법은 ArrayList 와 동일하다. ArrayList class 와 똑같은 메소드들을 모두 가지고 있기 때문이다.
 * 하지만 이 프로그램을 실행할 때 LinkedList 객체 내부에서  일어나는 일은 ArrayList 와는 완전히 다르다.
 * LinkedList 객체를 생성할 때는 ArrayList 객체 처럼 데이터를 저장할 수 있는 어떤 영역이 생기는 것이 아니다. - 객체를 생성한 다고 해서 데이터 저장 영역이 생기지 않는다.
 * add method 를 호출하는 경우에도 LinkedList 객체에 대해 처음으로 add method 를 호출하면 파라미터로 넘겨준 데이터가 LinkedList 안에 저장된다.
 * 두번째 add method 를 호출하면 이번에는 파라미터로 넘겨준 데이터가 먼저 저장된 데이터와 서로 상대방을 가리키는 형태로 저장된다.
 * 세번째로 add method 를 호출하면 파라미터로 넘겨준 데이터가 LinkedList 에 있는 마지막 데이터와 또 그런식으로 서로를 가리키게 된다.
 */
public class LinkedListExample1 {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>(); //LinkedList 객체를 생성한다.
		list.add("포도");
		list.add("딸기"); //add method 를 또 호출하면 마지막 데이터와 서로 가리키는 방식으로 저장된다.
		list.add("복숭아"); // add method 를 또 호출하면 다시 한번 마지막 데이터와 서로 가리키는 방식으로 저장된다.
		int num = list.size();
		for(int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}
	}
}
/*
 * LinkedList 객체 안에 있는 데이터들은 이렇게 서로 인접한 데이터를 가리키고 있기 때문에 모든 데이터의 위치를 일일이 관리할 필요가 없다.
 * 첫번째 데이터와 마지막 데이터의 위치만 보관하고 있으면 나머지 데이터는 링크(link, 서로 가리키는 연결 부분)를 따라가면서 찾을수 있다.
 * LinkedList class 의 get method 도 이런식으로 작동한다.
 * String str = list.get(2); - 인덱스 2 위치에 있는 데이터를 리턴한다. - 링크를 따라 인덱스 위치를 찾음
 */
