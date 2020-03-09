package DataStructure;

import java.util.LinkedList;
/*
 * LinkedList class 에는 ArrayList class 와 똑같은 기능을 하는 삽입/수정/삭제 메소드도 있다.
 * 하지만 이 프로그램에서 LinkedList 에 데이터를 삽입하고 수정하고, 삭제할 때 일어나는 일은 ArrayList 와는 다르다.
 * ArrayList 는 리스트 중간에 데이터를 삽입하면 그 뒤에 있는 데이터들이 모두 한 칸씩 뒤로 밀려나지만
 * LinkedList 의 경우에는 데이터의 삽입 위치의 앞뒤에 있는 데이터의 상호 링크를 끊고, 삽입할 데이터를 원래 링크를 맺고 있던 데이터와 한쪽씩 연결하는 방식으로 데이터가 삽입된다.
 * 데이터를 삭제할 때 ArrayList 의 경우에는 데이터를 삭제하면 그 뒤에 있는 데이터들이 한 칸씩 앞으로  이동하지만
 * LinkedList 의 경우에는 삭제되는 데이터와 인접한 데이터들의 링크가 끊어졌다가 두 데이터가 직접 연결되는 방식으로 삭제가 이루어진다.
 */
public class LinkedListExample2 {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		list.add(2, "키위"); //데이터를 삽입할 위치의 링크를 끊고(딸기 - 복숭아) 삽입되는 데이터와 새로운 링크를 맺는다(딸기 - 키위 - 복숭아)
		list.set(0, "오렌지"); //해당 인덱스에 있는 데이터의 내용을 변경한다.
		list.remove(1); //삭제할 데이터 양쪽의 링크를 끊은 후(오렌지 x 딸기 x 키위) 양쪽 데이터를 직접 연결한다.(오렌지 - 키위)
		list.remove("키위");
		int num = list.size();
		for(int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}
	}
}
/*
 * LinkedList 는 이런식으로 위와 같이 데이터를 삽입하고 삭제하기 때문에 데이터의 추가와 삭제가 빈번한 경우에는 ArrayList 보다 성능이 훨씬 우수하다.
 * 반면 인덱스로 데이터 항목을 찾는 일이 많은 프로그램의 경우에는 링크를 일일이 쫓아가면서 찾는 LinkedList 보다는 
 * 배열의 인덱스를 이용하여 데이터의 위치를 바로 찾을 수 있는 ArrayList 의 성능이 더 우수하다.
 */
