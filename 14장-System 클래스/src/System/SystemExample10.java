package System;
//arraycopy method 를 이용하면 같은 배열의 항목들을 앞쪽이나 뒤쪽으로 복사하는 것도 가능하다.
public class SystemExample10 {
	public static void main(String[] args) {
		int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.arraycopy(arr, 0, arr, 3, 5);
		for(int num : arr)
			System.out.println(num);
	}
}
