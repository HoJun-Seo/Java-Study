package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class StrmAverageClass {
	public static void main(String[] args) {
		List<Score> scores = Arrays.asList(
					new Score("서호준", 61, 71, 81),
					new Score("서호진", 62, 72, 82),
					new Score("동길이", 100, 100, 61)
				);
		System.out.println(scores.toString());
		
		// 수학점수 평균
		double avgMat = scores.stream().collect(
				Collectors.averagingInt(Score::getMat));
		System.out.println("수학 평균 : " + avgMat);
	}
}

@Data
@RequiredArgsConstructor
class Score{
	private final String name;
	private final int kor;
	private final int eng;
	private final int mat;
	private String msg;
}
