package Exception;
/*
 * 우리가 직접 생성해서 throw 하는 익셉션 객체에 대해서는 객체를 생성하는 방법에 따라 달라진다.
 * 예를 들어 Exception 객체를 생성할때 아무 파라미터도 넘겨주지 않으면 아무 에러 메시지도 설정되지 않지만, 문자열을 넘겨주면 그 문자열이 에러 메시지로 설정된다.
 */
public class ExceptionExample6 {
	public static void main(String[] args) {
		int num1 = 2, num2 = 3;
		try {
			int result = num1 - num2;
			if(result < 0)
				throw new Exception("잘못된 결과 입니다."); //익셉션 객체 생성
			System.out.println(result);
		}
		catch(Exception e) {
			String str = e.getMessage(); //익셉션 객체에 있는 에러 메시지를 가져온다.
			System.out.println(str);
		}
	}
}
