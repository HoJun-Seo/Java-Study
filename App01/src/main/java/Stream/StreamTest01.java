package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class StreamTest01 {

	public static void main(String[] args) {
		var list = Arrays.asList(1,2,3,2,1,5);
		System.out.println(list.toString());
		
		System.out.println("** HashSet 을 활용한 중복 제거 **");
		var<Integer> list2 = new ArrayList<Integer>(new HashSet<Integer>());
		list2.forEach(System.out::println);
		
		System.out.println("-- stream --");
		list.stream().distinct().forEach(System.out::println);
	}
}

/*
 * 반복 처리할 경우 stream() 을 적용
 * (반복 처리하여 연산)
 * 스트림 생성 -> 스트림 파이프라인
 */
