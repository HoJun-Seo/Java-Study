package basic;

public class MethodExample1 {
	public static void main(String[] args) {
		printCharacter('*', 30);//�޼ҵ� ȣ��
		System.out.println("Hello, Java");
		printCharacter('-', 30);//�޼ҵ� ȣ��
	}
	static void printCharacter(char ch, int num) { //�޼ҵ� ȣ��
		for(int cnt = 0; cnt < num; cnt++) 
			System.out.print(ch);
		System.out.println();
	}
}
