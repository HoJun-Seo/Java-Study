package basic;

public class ForExample5 {
	public static void main(String[] args) {
		int arr[] = {10, 20, 30, 40, 50};
		for(int num : arr)//향상된 for 문 활용 - 배열의 각 요소가 반복마다 num 변수에 대입된다.
		{
			System.out.println(num);
		}
		System.out.println("Done");
	}
}
