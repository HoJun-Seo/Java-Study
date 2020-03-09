package DataStructure;

import java.util.LinkedList;
/*
 * 큐는 스택과는 반대로 데이터를 넣은 순서와 같은 순서로만 꺼낼수 있다.
 * LinkedList 한쪽 끝을 큐의 입구로 사용하고, 다른 한쪽을 출구로 사용하며 LinkedList class 를 큐로 사용할 때는 리스트나 스택의 경우와는 다른 메소드를 사용해야 한다.
 * LinkedList 객체를 생성하고 나면 데이터를 추가할때 offer method 를 사용하며, poll method 를 통해 큐에 넣은 데이터를 가져올 수 있다.
 * queue.offer("토끼"); - 파라미터로 넘겨준 데이터를 큐로 저장한다.
 * str = queue.poll(); - 큐의 제일 앞에 있는 데이터가 리턴된다. - 해당 데이터는 큐에서 제거된다.
 * 큐에 있던 데이터를 제거하지 않고 가져오고 싶다면 peek method 를 사용한다.
 * str = queue.peek(); - 해당 데이터를 큐에서 제거하지 않고 리턴 한다.
 */
public class QueueExample1 {
	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<String>();
		queue.offer("토끼");
		queue.offer("사슴");
		queue.offer("호랑이");
		//큐에 3개의 데이터를 추가한다.
		while(!queue.isEmpty()) {
			String str = queue.poll();
			System.out.println(str);
			//루프를 돌면서 큐의 데이터를 모두 가져와서 출력한다.
		}
	}
}
