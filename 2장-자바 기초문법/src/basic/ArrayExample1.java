package basic;

public class ArrayExample1 {
	public static void main(String[] args) {
		int arr[]; //배열의 참조값을 저장하기 위한 변수 선언
		arr = new int[10]; //배열 변수의 메모리 확보
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = arr[0] + arr[1];
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}
}
