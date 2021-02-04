package classExam02;

/*
 * class final : 상속막기
 * method final : 오버라이딩 막기
 * 변수 final : 값 수정 막기
 */
public class class01 {
	protected int num; 
	protected String name;
	// protected : 상속관계에 있는 클래스 및 같은 패키지 내부 접근 허용
	// 다른 패키지의 경우 접근 불가능
	// private 은 상속관계에 있는 클래스라고 할 지라도 접근 불가
	
	public void print() {
		System.out.println("부모 클래스 class01 입니다.");
	}
	
	// 단일 클래스에서 생성자 테스트
	public class01(String name, int num) {
		System.out.println("class01 생성자 호출됨");
		this.num = num;
		this.name = name;
	}

	// 파라미터가 없는 생성자는 자식클래스에서 자동으로 호출
	// 상속관계의 에러방지 차원에서 형식적으로 작성
	public class01() {
	}

	@Override
	public String toString() {
		return "class01 [num=" + num + ", name=" + name + "]";
	}
	
	
}
