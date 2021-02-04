package classExam02;

public class Inherit02 extends Inherit01{
	
	private int num3;
	private int num4;
	
	// 파라미터가 없는 생성자 
	public Inherit02() {
		//자동으로 부모 클래스의 파라미터가 없는 생성자를 호출한다.
		System.out.println("Inherit02 인자 없는 생성자 호출됨");
	}

	// 파라미터가 있는 생성자
	public Inherit02(int num3, int num4) {
		super();
		this.num3 = num3;
		this.num4 = num4;
		System.out.println("Inherit02 인자 있는 생성자 호출됨");
	}
	
	

}
