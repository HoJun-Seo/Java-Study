package Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Spliterator;

public class SetObj {
	public static void main(String[] args) {
		var list = new ArrayList<String>();
		list.add("dog");
		list.add("dog");
		list.add("cat");
		list.add("cat");
		list.add("lion");
		list.add("lion");
		System.out.println("<<ArrayList>> : 중복 허용");
		System.out.println(list);
		
		var hs = new HashSet<String>();
		hs.addAll(list); // 리스트 전체를 set 구조에 한번에 삽입
		
		System.out.println("<<HashSet>> : 중복 허용 불가");
		System.out.println(hs);
		
		System.out.println("lion 추가 후 다시 출력");
		hs.add("lion");
		hs.forEach(System.out::println);
		
		//Spliterator (Iterator 와 유사) : 병렬 처리 특화
		// 참고로만 알아두자.
		System.out.println("<<Spliterator>>");
		Spliterator<String> nameSpliterator = hs.spliterator();
		nameSpliterator.forEachRemaining(System.out::println);
	}
}

// List 인터페이스 : 순서가 있음, 자료중복 허용
// Set 인터페이스 : 순서가 없음, 자료중복 불가능
