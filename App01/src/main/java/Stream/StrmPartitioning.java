package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StrmPartitioning {
	public static void main(String[] args) {
		List<Score> scores = Arrays.asList(
				new Score("홍길동", 61, 71, 81),
				new Score("홍길순", 62, 72, 82),
				new Score("동길이", 100, 100, 61)
				);
		
		// 수학 80점 이상인 사람과 그렇지 않은 사람 구분
		Map<Boolean, List<Score>> result = 
				scores.stream().collect(Collectors.partitioningBy(s -> {
					return (s.getMat() > 80) ? true : false;
				}));
		
		System.out.println("** 수학 80점 이상인 고득점자 **");
		List<Score> list = result.get(true);
		for(Score score : list) {
			System.out.println(score.getName() + " " + score.getMat());
		}
		
		// 수학 80점 이상인 사람과 그렇지 않은 사람은 각각 몇명인가?
		Map<Boolean, Long> count = scores.stream().collect(Collectors.partitioningBy(
				s -> {
					return (s.getMat() > 80) ? true : false;
				}, Collectors.counting()));
		System.out.printf("80점 이상인 사람은 %d 명이다.", count.get(true));
	}
}

/*
 * partitioningBy()
 *  Predicate 함수형 인터페이스를 인자로 사용
 *  스트림으로 넘어온 요소들 처리 후 Boolean 자료형으로만 반환
 */
