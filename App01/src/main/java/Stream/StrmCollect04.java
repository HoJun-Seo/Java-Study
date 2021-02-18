package Stream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StrmCollect04 {
	public static void main(String[] args) {
		List<String> G7 = Stream.of("미국", "영국", "프랑스", "독일", "이탈리아", "캐나다","일본")
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						Collections::unmodifiableList));
		System.out.println(G7);
		try {
			G7.add("한국"); // 리스트가 변경불가 상태이므로 
			// 프로그램 실행 시 익셉션이 발생한다.
			/*
			 * java.lang.UnsupportedOperationException
			 * Collections$UnmodifiableCollection.add
			 */
		}catch (UnsupportedOperationException e) {
			System.out.println("변경 불가능한 리스트 입니다.");
		}
		
	}
}
/*
 * collection 클래스를 수정할수 없는 상태로 변환
 * unModifiableList(), toUnmodifiableMap(), toUnmodifiableSet()
 */
