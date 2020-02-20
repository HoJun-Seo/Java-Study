package basic;

public class TryExample {
	public static void main(String[] args) {
		int divisor[] = {5, 4, 3, 2, 1, 0};
		for(int cnt = 0; cnt < 10; cnt++) {
			try {
				int share = 100 / divisor[cnt];
				System.out.println(share);
			}
			catch(java.lang.ArithmeticException e) {//100�� 0���� ������� - �Ұ����� ���꿡 ���� �ͼ���
				System.out.println("�߸��� �����Դϴ�.");
			}
			catch(java.lang.ArrayIndexOutOfBoundsException e) { // �������� �ʴ� �迭�� �ε��� ���� ���� �Ͽ����� �߻��ϴ� �ͼ���
				System.out.println("�߸��� �ε��� �Դϴ�.");
			}
		}
		System.out.println("Done");
	}
}
