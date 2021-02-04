package classExam02;

public class class01Inherit extends class01 {
	public static void main(String[] args) {
		
		// 부모 클래스
		class01 p = new class01();
		p.name = "부모이름";
		p.num = 100;
		p.print();
		System.out.println("=========");
		
		// 자식 클래스2
		class02 cl02 = new class02("서호준", 100, "부산");
		cl02.print();
		System.out.println(cl02.toString() + " " + cl02.addr);
		// 자식 클래스1
		class01Inherit cl01 = new class01Inherit();
		cl01.print();
		
		// 상속관계 에서 주의할 점
		// 큰것 = 작것 허용된다. float i = 10;
		class01 parent = new class02(); // 자식 클래스로 부모 클래스의 객체를 만드는 것이 가능하다.
		parent.print();
		
		class02 child = (class02) parent;
		child.print();
		
		/*
		 * 부모클래스 부모주소변수 = 부모클래스 생성자 통한 메모리 주소
		 * 자식클래스 자식주소변수 = 자식클래스 생성자 통한 메모리 주소
		 * 
		 * 부모 클래스 부모주소변수 = 자식클래스 생성자 통한 메모리 주소
		 * 자식 클래스 자식주소변수 = (자식클래스) 부모 주소변수
		 */
		
	}
	@Override
	public void print() {
		System.out.println("부모 클래스 class01 에서 상속받은 class01Inherit 클래스 입니다.");
	}
}
