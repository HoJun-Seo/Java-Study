package object_class;

public class HundredNumbers {
	static int arr[];
	static { //정적 초기화 블록 - 정적 필드의 초기값을 필드 선언문에서 대입할 수 없을때 사용한다.
			//정적 필드는 특정 객체에 속하지 않기 때문에, 생성자에서 초기값을 대입할 수 없음.
		arr = new int[100];
		for(int cnt = 0; cnt < 100; cnt++)
			arr[cnt] = cnt;
	}
}
