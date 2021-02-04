package classExam02;

public class class02 extends class01{
	
	String addr;
	
	public class02() {
		super(); // 내부적으로 작동하고 있기 때문에 오류가 발생하지 않는다.(파라미터 없는 생성자)
		System.out.println("class02 생성자 호출됨");
	}

	public class02(String name, int num, String addr) {
		// 부모클래스 생성자 호출하여 초기화 작업한다.
		super(name, num);
		this.addr = addr;
	}

	@Override
	public void print() {
		System.out.println("부모 클래스 class01 에서 상속 받은 class02 입니다.");
	}
}
