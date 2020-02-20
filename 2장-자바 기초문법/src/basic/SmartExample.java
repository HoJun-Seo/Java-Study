package basic;

public class SmartExample {
	public static void main(String[] args) {
		int a = 3, b = 0;
		int result;
		try {
			result = a / b;
			System.out.println(result);
		}
		catch(java.lang.ArithmeticException e) { //3�� 0���� ���� - �Ұ����� ���꿡 ���� �ͼ���
			System.out.println("�߸��� �����Դϴ�.");
		}
		System.out.println("Done");
		//finally ����� ���� �����ϴ�.
		/*finally {
			System.out.println("Done");
		}*/
		/*
		 * try-catch �� : exception ó���� ���� ����
		 * try ��Ͽ��� �ͼ����� �߻��� ���ɼ��� �ִ� ��ɹ��� ��־�� �ϰ�
		 * catch ��Ͽ��� �� �ͼ����� ó���ϴ� ��ɹ��� ��־�� �Ѵ�.(try ��Ͽ��� �ͼ��� �߻��� catch ��� ����)
		 * finally ��� �ȿ��� �ͼ��� �߻� ���ο� ������� �� �������� ������ ��ɹ� ���� ��־�� �Ѵ�.
		 * 
		 * java.lang.ArithmeticException e
		 *  : java.lang.ArithmeticException - �ͼ��� ������ Ÿ��
		 *    �ݵ�� �߻��ϴ� �ͼ����� ������ �¾ƾ� �ϹǷ� ���α׷��Ӱ� ���Ƿ� ������ �� ����.
		 *  : e - �ͼ��� ������ �̸�
		 *    �ٸ� ������ ���� ���������� ���α׷��Ӱ� ������� ���� �� �ִ�.
		 */
	}
}
