package operator;

public class AssignmentExample3 {
	public static void main(String[] args) {
		int num1, num2;
		num2 = (num1 = 10); //대입 연산자가 산출하는 값을 이용한다.(코드 줄 수 줄이는데 도움 될 듯)
		System.out.println(num1);
		System.out.println(num2);
	}
}
