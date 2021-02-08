package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetObj {

	public static void main(String[] args) {
		var arr = new ArrayList<String>();
		arr.add("사자");
		arr.add("호랑이");
		arr.add("원숭이");
		System.out.println("1.ArrayList 를 TreeSet 으로");
		
		System.out.println("ArrayList : " + arr); // 입력된 순서대로 출력
		var trs = new TreeSet<String>();
		trs.addAll(arr);
		System.out.println("TreeSet : " + trs); // Set 은 입력 순서에 영향을 받지 않는다.
		
		System.out.println("2. TreeSet 타이거 추가");
		trs.add("타이거");
		System.out.println("TreeSet : " + trs);
		
		String addString = "토끼";
		if(trs.contains(addString)) { // 데이터가 포함되어 있다면 true
			System.out.println("TreeSet 에 " + addString + " 이(가) 있습니다.");
		} else {
			System.out.println("TreeSet 에 " + addString + " 이(가) 없습니다.");
			System.out.println("데이터를 추가합니다.");
			trs.add(addString);
		}
		System.out.println("TreeSet : " + trs);
		
		System.out.printf("TreeSet 에 '%s' 보다 크거나 같은 값 중에 제일 가까운 값 출력 : %s",
				"자", trs.ceiling("자")); // 근사값 찾기 (ceiling 메소드)
		System.out.printf("\nTreeSet 에 '%s' 보다 작거나 같은 값 중에 제일 가까운 값 출력 : %s",
				"자", trs.floor("자")); // 근사값 찾기 (floor 메소드)
		System.out.printf("\nTreeSet 에 '%s' 보다 큰 값 출력 : %s", "토끼", trs.higher("토끼"));
		System.out.printf("\nTreeSet 에 '%s' 보다 작은 값 출력 : %s", "토끼", trs.lower("토끼"));
		System.out.printf("\nTreeSet 에 첫번째 값 : %s ", trs.first());
		System.out.printf("\nTreeSet 에 마지막번째 값 : %s ", trs.last());
		
		System.out.println(">> 정렬");
		Iterator<String> it = trs.descendingIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("첫번째 요소 반환(출력) 후 삭제");
		System.out.println("반환값 : " + trs.pollFirst());
		System.out.println(trs);
		System.out.println("마지막 요소 반환(출력) 후 삭제");
		System.out.println("반환값 : " + trs.pollLast());
		System.out.println(trs);
	}
}

// 이진트리 구조 형태
