package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StrmCollect05 {
	public static void main(String[] args) {
		// 스트림의 자료형별 배열의 평균을 구하는 Collectors 객체의 메소드
		List<Integer> list = Arrays.asList(100, 100, 61, 85, 91);
		System.out.println("평균 : " + list.stream()
			.collect(Collectors.averagingInt(i -> i)));
		
		List<Double> list2 = Arrays.asList(100.0, 80.8, 61.7, 85.4, 91.9);
		System.out.println("평균 : " + list2.stream()
		    .collect(Collectors.averagingDouble(i -> i)));
		
		List<Long> list3 = Arrays.asList(100L, 100L, 61L, 85L, 91L);
		System.out.println("Long 평균 : " + list3.stream()
			.collect(Collectors.averagingLong(i -> i)));
	}
}
