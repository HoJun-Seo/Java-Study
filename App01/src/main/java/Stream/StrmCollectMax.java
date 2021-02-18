package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StrmCollectMax {
	public static void main(String[] args) {
		List<Score> scores = Arrays.asList(
				new Score("홍길동", 61, 71, 81),
				new Score("홍길순", 62, 72, 82),
				new Score("동길이", 100, 100, 61)
				);
		
		System.out.println("** 국어 최저 점수 학생 **");
		scores.stream()
			.collect(Collectors.minBy(
					Comparator.comparing(Score::getKor)
						)
					)
			.ifPresent(System.out::println);
		
		// 영어가 최고 점수인 학생
		// 이름순으로 제일 빠른 학생
		// 이름순으로 제일 느린 학생
		System.out.println("--- 영어 ---");
		scores.stream()
			.collect(Collectors.maxBy(
					Comparator.comparing(Score::getEng)
					)
				)
			.ifPresent(System.out::println);
		
		System.out.println("-- 이름순 정렬 --");
		scores.stream()
			.sorted(Comparator.comparing(Score::getName))
			.forEach(System.out::println);
		
		System.out.println("-- 이름 역순 정렬 --");
		scores.stream()
		.sorted(Comparator.comparing(Score::getName).reversed())
		.forEach(System.out::println); 
	}
}
