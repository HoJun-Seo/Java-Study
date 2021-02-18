package Stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StrmCollect03 {
	public static void main(String[] args) {
		List<String> locals = Arrays.asList("서울", "대전", "대구", "광주", "부산", "제주");
		
		List<String> reversedLocals = locals.stream()
				.collect(Collectors.collectingAndThen( // 처리 후 추가작업
						Collectors.toList(), // 첫번째 인자 : 1. List 자료형 변환
						city -> { // 두번째 인자 : 2. 추가작업으로 역순으로 처리
					Collections.reverse(city);
					return city.stream(); // 2-1. 스트림 생성
				})).collect(Collectors.toList()); // collectingAndThen() 수행 후 List 자료형으로 변환
		
		// 정렬 전
		System.out.println(locals.toString());
		
		// 정렬 후
		System.out.println(reversedLocals.toString());
	}
}
/*
 * Collectors.collectingAndThen(수행할 내용, 추가 작업할 내용)
 */
