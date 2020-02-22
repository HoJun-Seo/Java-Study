package object_class;

public class MethodExample2 {
	public static void main(String[] args) {
		int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		Numbers obj = new Numbers(arr);
		int total = obj.getTotal();
		int average = obj.getAverage();
		System.out.println("합계 = " + total);
		System.out.println("합계 = " + average);
	}
}
