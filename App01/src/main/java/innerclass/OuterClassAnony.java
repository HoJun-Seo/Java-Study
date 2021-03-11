package innerclass;

// 익명 내붘 클래스 사용
public class OuterClassAnony {
	Runnable getRunnable(int i) {
		int num = 100;
		
		return new Runnable() { // 메소드 반환 형태의 익명 내부 클래스
			
			@Override
			public void run() {
				System.out.println(i);
				System.out.println(num);
			}
		}; // 클래스 끝에 ; 를 사용
	}
	
	Runnable runner = new Runnable() { // 변수 반환 형태의 익명 내부 클래스
		/* 인터페이스나 추상 클래스 자료형으로 변수를 선언한 후 익명 내부 클래스를 생성해 대입할 수 있다.*/
		@Override
		public void run() {
			System.out.println("Runnable 이 구현된 익명 클래스 입니다.");
		}
	};
}
