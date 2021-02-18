package Stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StrmCollectGroupingBy {
	public static void main(String[] args) {
		// 학점 : 90 이상 A, 80 이상 B, 70 이상 C, 60 이상 D, 외는 F
		// 학점을 기준으로 그룹핑하여 학점의 대상이 되는 이름을 출력
		List<Score> scores = Arrays.asList(
				new Score("홍길동", 61, 71, 81),
				new Score("홍길순", 62, 72, 82),
				new Score("동길이", 100, 100, 61)
				);
		
		// 기본 값
		scores.forEach(System.out::println);
		
		// 수학 점수를 기준으로 학점 계산
		Map<String, List<Score>> result = 
				scores.stream().collect(
						Collectors.groupingBy(s -> {
							return (s.getMat() > 90) ? "A" : 
									(s.getMat() > 80) ? "B" :
									(s.getMat() > 70) ? "C" :
									(s.getMat() > 60) ? "D" : "F";
						}));
		
		System.out.println(result.keySet());
		result.keySet().forEach(key -> {
			System.out.printf("** 수학 %s 학점 ** \n", key);
			List<Score> score = result.get(key);
			
			score.stream().forEach(s -> System.out.println(s.getName()));
		});
		
		System.out.println("---- Map test ----");
		Map<String, Integer> test = new HashMap<String, Integer>();
		test.put("A", 100);
		test.put("B", 200);
		test.put("C", 300);
		
		System.out.println(test.get("A"));
		System.out.println(test.get("B"));
		System.out.println(test.get("C"));
	}
}
