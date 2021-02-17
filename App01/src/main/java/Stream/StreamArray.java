package Stream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamArray {

	public static void main(String[] args) {
		String[] strArr = {"홍길동", "홍길순", "동순이"};
		int[] intArr = {3,6,9};
		double[] doubleArr = {3.1,4.2,5.3};
		
		// 스트림 생성
		Stream<String> strStm = Arrays.stream(strArr);
		IntStream intStm = Arrays.stream(intArr);
		DoubleStream doubleStm = Arrays.stream(doubleArr);
		
		// 출력
		strStm.forEach(System.out::println);
		intStm.forEach(System.out::println);
		doubleStm.forEach(System.out::println);
	}
}

/*
 *  배열을 스트림의 형태로 변환 후 Stream 객체를 이용한다.
 *  static<T> Stream<T> of(T t) : 배열을 스트림으로 변환
 *  static<T> Stream<T> of(T ...values) : 여러개의 배열을 순차적은 스트림으로 변환
 */
