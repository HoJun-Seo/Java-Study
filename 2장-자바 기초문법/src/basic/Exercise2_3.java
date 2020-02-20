package basic;

public class Exercise2_3 {
	public static void main(String[] args) {
		int arr[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
		int i = 0, result = 0;
		for(i = 2; i < 7; i++)
		{
			result += arr[i];
		}
		System.out.println(result);
	}
}
