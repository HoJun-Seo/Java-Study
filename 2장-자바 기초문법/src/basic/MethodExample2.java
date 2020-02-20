package basic;

public class MethodExample2 { 
	public static void main(String[] args) {
		int result;
		result = add(3, 4);
		System.out.println(result);
	}
	static int add(int num1, int num2) { //리턴 값을 돌려주는 메소드
		int sum;
		sum = num1 + num2;
		return sum;
	}
}
