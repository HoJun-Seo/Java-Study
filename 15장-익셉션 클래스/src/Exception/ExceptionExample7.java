package Exception;
/*
 * 익셉션이 발생한 경로를 추적하는 메소드
 * printStackTrace method getMessage method 와는 달리 에러 메시지를 리턴하는 것이 아니라, 표준 에러 출력을 통해 에러 메시지를 출력한다.
 * 결과에는 익셉션 클래스의 이름과 에러 메시지 뿐만이 아니라, 익셉션이 발생한 클래스와 메소드의 이름, 소스 코드에서의 행 번호까지 출력된다.
 * 그렇기 때문에 이 메소드는 복잡하고 큰 프로그램에서 익셉션의 발생 위치를 찾을 때 유용하다.
 * 하지만 이렇게 복잡한 메시지는 사용자에게 혼란을 줄 수 있으므로, 완성된 프로그램에서는 사용하지 않는 것이 좋고 개발 단계 디버깅 목적으로만 사용해야 한다.
 */
public class ExceptionExample7 {
	public static void main(String[] args) {
		try {
			int arr[] = new int[0];
			System.out.println("합계" + getTotal(arr));
			System.out.println("평균" + getAverage(arr));
		}
		catch(Exception e) {
			e.printStackTrace();
			//익셉션이 처리되는 부분
		}
	}
	static double getAverage(int arr[]) throws Exception {
		if(arr.length == 0)
			throw new Exception("비어있는 배열 입니다."); //익셉션이 발생하는 부분
		return getTotal(arr) / arr.length;
	}
	static int getTotal(int arr[]) throws Exception {
		if(arr.length == 0)
			throw new Exception("비어있는 배열입니다."); //익셉션이 발생하는 부분
		int total = 0;
		for(int num : arr)
			total += num;
		return total;
	}
}
