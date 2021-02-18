package Stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class StrmCollectCounting {
	public static void main(String[] args) {
		List<FreeBoard> list = Arrays.asList(
				new FreeBoard(1, "가입 인사", "안녕하세요"),
				new FreeBoard(2, "가입 인사", "반갑습니다."),
				new FreeBoard(3, "질문 있습니다.", "자바 공부중입니다.")
				);
		
		System.out.println(list.toString());
		System.out.println("--- 람다식 ---");
		list.forEach(content -> System.out.println(content.toString()));
		System.out.println("-- 메소드 참조 --");
		list.forEach(System.out::println);
		
		List<FreeBoard> reversedList = 
				list.stream().collect(
						Collectors.collectingAndThen(Collectors.toList()
								, content -> {
									Collections.reverse(content);
									return content.stream();
								})).collect(Collectors.toList());
		System.out.println("중간");
		reversedList.forEach(System.out::println);
		
		long cnt = list.stream().collect(Collectors.counting());
		System.out.println("개수 : " + cnt);
	}
}

@Data
@ToString
@AllArgsConstructor
class FreeBoard{
	private int no;
	private String title;
	private String contents;
}
