package chap01;

public class sw01 {

	public static void main(String[] args) {
		int num = 1;
		switch (num) {
		case 1,3,5: 
			System.out.println("홀수");
			break;
		case 2,4,6:
			System.out.println("짝수");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + num);
		}
	}

}
