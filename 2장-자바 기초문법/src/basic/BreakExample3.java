package basic;

public class BreakExample3 {
	public static void main(String[] args) {
		outerloop: //���� �̿��� ��ø �ݺ��� Ż��
			for(int row = 0; row < 3; row++) {
				for(int col = 0; col < 5; col++) {
					System.out.println("(" + row + ", " + col + ")");
					if((row == 1) && (col == 3))
						break outerloop;
				}
			}
		System.out.println("Done");
	}
}
