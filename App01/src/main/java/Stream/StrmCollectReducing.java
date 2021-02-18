package Stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StrmCollectReducing {
	public static void main(String[] args) {
		long sum1 = IntStream.rangeClosed(2, 10).reduce(0, Integer::sum);
		System.out.println("reduce() 합계 : " + sum1);
		
		IntStream range = IntStream.rangeClosed(2, 10);
		long sum2 = range.boxed().collect(Collectors.reducing(1,Integer::sum));
		
		System.out.println("Collectors.reducing() 합계 : " + sum2);
	}
}
