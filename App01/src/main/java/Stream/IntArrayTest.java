package Stream;

import java.util.Arrays;

public class IntArrayTest {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		// sum() 연산으로 arr 배열에 저장된 값을 모두 더함
		int sumVal = Arrays.stream(arr).sum();
		// count() 연산으로 arr 배열의 요소 개수를 반환함
		int count = (int) Arrays.stream(arr).count();
		// count() 메소드의 반환 값이 long 형이므로 int 형으로 변환.
		
		System.out.println(sumVal);
		System.out.println(count);
	}

}
