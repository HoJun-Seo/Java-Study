package System;
/*
 * 배열을 일괄 복사하는 메소드
 * System class 에는 배열의 일부 또는 전체를 일괄 복사하는 arraycopy method 도 있다.
 * arraycopy method 를 사용하면 반복문을 사용하지 않고도 배열의 내용을 복사할 수 있다.
 * arraycopy method 는 5개의 파라미터를 받는다. 1.원본 배열, 2.원본 항목의 시작 위치, 3. 복사 대상 배열, 4. 복사 대상 항목의 시작위치, 5. 복사할 항목의 수
 */
public class SystemExample9 {
	public static void main(String[] args) {
		char arr1[] = {'가', '나', '다', '라', '마', '바', '사', '아', '자', '차', '카', '타', '파', '하'};
		char arr2[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};
		System.arraycopy(arr1, 10, arr2, 2, 3);
		for(char ch : arr2)
			System.out.println(ch);
	}
}
