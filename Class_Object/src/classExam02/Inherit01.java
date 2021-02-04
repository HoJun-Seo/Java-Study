package classExam02;

public class Inherit01 {
	
	protected int num1;
	protected int num2;
	
	// default 생성자 - 무조건 작성
	public Inherit01() {
		System.out.println("Inherit01 인자 없는 생성자 호출함");
		num1 = 10;
		num2 = 20;
	}

	// 파라미터가 있는 생성자
	public Inherit01(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		System.out.println("Inherit01 인자 있는 생성자 호출함");
	}

	@Override
	public String toString() {
		return "Inherit01 [num1=" + num1 + ", num2=" + num2 + "]";
	}
	
	
	
}
