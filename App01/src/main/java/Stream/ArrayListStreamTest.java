package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>();
		sList.add("Tomas");
		sList.add("Edward");
		sList.add("Jack");
		
		Stream<String> stream = sList.stream(); // 스트림 생성
		stream.forEach(s -> System.out.println(s)); // 배열 요소를 하나씩 출력
		System.out.println();
		
		sList.stream().sorted().forEach(s -> System.out.println(s));
	}

}
