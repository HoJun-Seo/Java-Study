package operator;

public class AssignmentExample3 {
	public static void main(String[] args) {
		int num1, num2;
		num2 = (num1 = 10);
		System.out.println(num1);
		System.out.println(num2);
	}
}
