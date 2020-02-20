package basic;

public class ContinueExample3 {
	public static void main(String[] args) {
		outerloop: //중첩 반복문에서 바깥쪽 반복문에 continue를 적용하기 위해 라벨을 사용한다.
			for(int row = 0; row < 3; row++) {
				for(int col = 0; col < 5; col++) {
					if((row == 1) && (col == 3))
						continue outerloop;
					System.out.println("(" + row + ", " + col + ")");
				}
			}
		System.out.println("Done");
	}
}
