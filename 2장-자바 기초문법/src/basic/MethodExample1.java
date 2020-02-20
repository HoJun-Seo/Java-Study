package basic;

public class MethodExample1 {
	public static void main(String[] args) {
		printCharacter('*', 30);//메소드 호출
		System.out.println("Hello, Java");
		printCharacter('-', 30);//메소드 호출
	}
	static void printCharacter(char ch, int num) { //메소드 호출
		for(int cnt = 0; cnt < num; cnt++) 
			System.out.print(ch);
		System.out.println();
	}
}
