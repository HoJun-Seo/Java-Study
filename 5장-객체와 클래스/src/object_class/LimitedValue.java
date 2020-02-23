package object_class;

public class LimitedValue {
	final static int UPPER_LIMIT = 100000; //상수 필드의 선언(final static) - 상수에 이름을 붙여서 사용할 경우 : 
											//소스 코드에서 주어진 초기값을 프로그램 실행 중에 절대 바꿀수 없다.
	int value;
	void setValue(int value) {
		if(value < UPPER_LIMIT)
			this.value = value;
		else
			this.value = UPPER_LIMIT; //상수 필드의 사용
	}
}
