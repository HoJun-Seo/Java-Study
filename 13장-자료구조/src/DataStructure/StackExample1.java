package DataStructure;

import java.util.LinkedList;
/*
 * 스택으로 사용할수 있는 클래스
 * jdk 라이브러이 에 있는 자료구조 클래스 중에는 LinkedList class 가 스택으로 사용하기에 가장 적합한 클래스이다. - 한쪽 끝으로만 데이터를 넣고 꺼내면 스택처럼 사용할 수 있기 때문
 * 객체 생성 - LinkedList<Integer> stack = new LinkedList<Integer>();
 * 생성된 객체를 스택으로 사용하려면 리스트의 어느쪽을 스택의 입구로 사용할지 정해야 한다. - 보통 리스트의 끝 부분을 스택의 입구로 사용함
 * 리스트의 끝 부분에 데이터를 넣을 때는 addLast method 를 사용해야 한다.
 * 예) list.addLast(new Integer(12)); - addLast method 는 데이터를 스택의 아래쪽부터 순서대로 저장한다.(타입 파라미터에 해당하는 데이터를 넘겨줘야 한다.)
 * 스택에 넣은 데이터를 다시 꺼내오기 위해서는 removeLast method 를 사용해야 한다.
 * 이 메소드는 연결리스트의 마지막에 있는 데이터를 꺼내오는 메소드 이지만 리스트의 끝을 스택의 입구로 사용하기로 했으니, 스택의 입구에 있는 데이터를 가져오는 셈이다.
 * Integer obj = removeLast(); - 스택의 제일 위에 있는 데이터를 리턴 받으며, 해당 데이터는 스택에서 제거된다.
 * 스택에 있는 데이터를 제거하지 않고 가져오는 메소드는 getLast method 이다.
 * Integer obj = getLast(); - 스택의 제일 위에 있는 데이터를 리턴한다. 해당 데이터는 스택에서 제거되지 않고 유지된다.
 */
public class StackExample1 {
	public static void main(String[] args) {
		LinkedList<Integer> stack = new LinkedList<Integer>(); //스택으로 사용할 LinkedList 객체를 생성한다.
		stack.addLast(new Integer(12));
		stack.addLast(new Integer(59));
		stack.addLast(new Integer(7));
		//스택에 3개의 데이터를 추가한다.
		while(!stack.isEmpty()) {
			Integer num = stack.removeLast();
			System.out.println(num);
			//루프를 돌면서 스택의 데이터를 모두 가져와서 출력한다.
		}
	}
}
/*
 * LinkedList class 에는 addFirst, removeFirst, getFirst method 도 있는데
 * 이 메소드들은 각각 리스트의 앞 부분에 데이터를 추가하고, 삭제하고, 가져오는 메소드이다.
 * 그렇기 때문에 이 메소드들을 이용하면 리스트의 앞 부분을 스택의 입구로 사용할 수 있다.
 */
