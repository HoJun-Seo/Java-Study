package basic;

public class TryExample {
	public static void main(String[] args) {
		int divisor[] = {5, 4, 3, 2, 1, 0};
		for(int cnt = 0; cnt < 10; cnt++) {
			try {
				int share = 100 / divisor[cnt];
				System.out.println(share);
			}
			catch(java.lang.ArithmeticException e) {//100을 0으로 나눌경우 - 불가능한 연산에 관한 익셉션
				System.out.println("잘못된 연산입니다.");
			}
			catch(java.lang.ArrayIndexOutOfBoundsException e) { // 존재하지 않는 배열의 인덱스 값을 찹조 하였을때 발생하는 익셉션
				System.out.println("잘못된 인덱스 입니다.");
			}
		}
		System.out.println("Done");
	}
}
