package basic;

public class SwitchExample2 { //break ���� ������ ����
	public static void main(String[] args) {
		char ch = 'p';
		switch(ch)
		{
		case 'A':
		case 'a':
			System.out.println("���");
			break;
		case 'P':
		case 'p':
			System.out.println("��");
			break;
		case 'G':
		case 'g':
			System.out.println("����");
			break;
		default:
				System.out.println("?");
				break;
		}
	}
}
