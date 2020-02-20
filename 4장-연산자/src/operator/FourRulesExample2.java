package operator;

public class FourRulesExample2 {
	public static void main(String[] args) {
		byte a = 2, b = 3, sum;
		sum = a + b; /*
		*a + b 의 결과 값은 int형 으로 변환 되는데, 해당 명령문은  int형의 결과값을 표현 범위가 더 작은 byte 타입의 변수에 저장하고 있기 때문에 문제가 발생한다.
		*/System.out.println(sum);
	}
}
