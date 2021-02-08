package Collection;

import java.util.ArrayList;
import java.util.Iterator;

public class IterObj01 {

	public static void main(String[] args) {
		var list = new ArrayList<String>();
		list.add("dog");
		list.add("cat");
		list.add("lion");
		
		System.out.println(list);
		System.out.printf("총 %d의 자료가 있습니다.\n", list.size());
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String item = it.next();
			System.out.println("반복처리중 자료 추출 : " + item);
			
			if("cat".equals(item)) {
				it.remove(); // "cat" 내용이면 삭제
			}
		}
		
		System.out.println("\n" + list);
		System.out.printf("총 %d의 자료가 있습니다.\n", list.size());
	}

}
