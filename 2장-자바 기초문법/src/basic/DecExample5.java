package basic;

public class DecExample5 {
	public static void main(String[] args) {
		int num = 10; //중괄호 내부에서 선언된 변수는 밖에서 사용이 불가능하나, 밖에서 선언된 변수는 안에서 사용이 가능하다.
		{
			num = 30;
		}
		System.out.println(num);
	}
}
