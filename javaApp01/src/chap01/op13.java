package chap01;

public class op13 {

	public static void main(String[] args) {
		int odd = 0, even = 0;
		for(int i = 1; i <= 10; i++) {
			System.out.println("숫자 발생 : " + i);
			
			if(i % 2 == 0) {
				even += i;
			}
			else {
				odd += i;
			}
		}
		System.out.println("짝수 : " + even + " 홀수 : " + odd);
	}

}
