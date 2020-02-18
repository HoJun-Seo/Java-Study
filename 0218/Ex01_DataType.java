package dataType;

public class Ex01_DataType {
	public static void main(String[] args) {
		 //자료형 : 사람이 나타내고 싶은 데이터가 컴퓨터 내에서 식별되기 위한 형태
		
		//자바의 기본 자료형(primitive type)
		
		/*
		 * 	byte : 1 바이트 정수 자료형
		 * 	boolean : 1 바이트 논리 자료형(true/false)
		 * 	short : 2 바이트 정수 자료형
		 *  char : 2 바이트 정수 자료형(+,- 부호 없음)
		 *  int : 4 바이트 정수 자료형
		 *  long : 8 바이트 정수 자료형
		 *  float : 4 바이트 실수 자료형
		 *  double : 8 바이트 실수 자료형(실수의 대표 자료형)
		 */
		
		//변수 선언 : 새로운 변수를 생성, [자료형] [변수 이름];
		
		boolean bo;
		
		//변수 초기화 : 변수를 선언하면서, 값을 할당하는 작업
		
		byte by = 100;
		char ch = 65;
		short sh = 66;
		int num = 1234;
		long ln = 1000000L; //long 값은 뒤에 소문자 혹은 대문자로 L을 명시한다.
		
		float fl = 1.2f; //float은 값 뒤에 대/소문자로 f를 명시한다.(float 값임을 알려주기 위해(기본값은 double이다.))
		double db = 3.14; 
		
		bo = true; //선언 이후에도 값을 할당(대입)
		System.out.println(bo);
		// 함수 내의 변수는 값이 할당되어 있어야 출력할 수 있다.
		
		System.out.println("문자열은 쌍따옴표로 묶어준다.");
		System.out.println();
		
		System.out.println("ch : " + ch);
		//문자열과 변수를 + 로 묶어주면 나열하여 같이 출력한다.
		System.out.println("sh : " + sh);
	}
}
