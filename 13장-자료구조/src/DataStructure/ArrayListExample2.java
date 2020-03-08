package DataStructure;

import java.util.ArrayList;
/*
 * ArrayList 에 데이터를 삽입/수정/삭제하는 방법
 * ArrayList 중간에 데이터를 삽입하려면 add method 를 사용하는데, 첫 번째 파라미터로 데이터가 들어갈 위치의 인덱스를 넘겨주고 두번째 파라미터로 데이터를 넘겨줘야 한다.
 * ArrayList 중간에 데이터를 삽입하게 되면 원래 그 위치에 있던 데이터부터 리스트의 마지막까지의 데이터는 한 칸씩 뒤로 이동하게 된다.
 * list.add(2, "키위"); - 인덱스 2 위치에 "키위" 를 삽입한다.
 * 기존 데이터를 다른 데이터로 교체하고자 할 때는 set method 를 사용하면 된다.이 메소드도 파라미터로 인덱스와 데이터를 받는다.
 * list.set(0, "오렌지"); - 인덱스 0 위치에 있는 데이터를 "오렌지" 로 바꾼다.
 * 리스트에서 데이터를 삭제 할 때는 remove method 를 사용하면 된다. 이 메소드는 삭제 할 데이터의 인덱스를 파라미터로 받는데
 * 해당 데이터가 삭제되고 나면 뒤에 있던 데이터 들은 한 칸씩 앞으로 이동하게 된다.
 * list.remove(1); - 인덱스 1 위치에 있는 데이터를 삭제한다.
 * remove method 에는 인덱스 파라미터 대신 삭제할 데이터와 똑같은 값을 갖는 데이터를 넘겨줄 수도 있다. 그렇게 하면 그와 똑같은 값을 갖는 데이터 하나가 리스트에서 삭제된다.
 * list.remove("키위"); - 리스트에서 "키위" 라는 데이터를 찾아 삭제한다.
 */
public class ArrayListExample2 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		list.add(2, "키위");
		list.set(0, "오렌지");
		list.remove(1);
		list.remove("키위");
		int num = list.size();
		for(int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}
	}
}
