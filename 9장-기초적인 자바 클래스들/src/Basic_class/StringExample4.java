package Basic_class;

public class StringExample4 {
	public static void main(String[] args) {
		String str1 = "자바";
		//String str1 = new String("자바");
		String str2 = "자바";
		//String str2 = new String("자바");
		if(str1.equals(str2))//문자열의 내용을 비교하는 메소드 - ==, != 연산자와는 다르게 문자열의 참조값이 아니라 문자열의 내용을 가지고 비교를 하기 때문에
							//==, != 연산자를 사용했을 때 보다 더 정확한 비교가 가능하다
							//==, != 연산자 같은 경우는 주석 처리를 해놓은 new String 과 같은 객체 생성으로 문자열을 만들어서 비교할시
							//내용은 같다고 할지라도 서로 다른 객체로 취급되고, 참조 값을 통해 비교를 하기 때문에 서로 다른 문자열 이라는 결과를 리턴받게 된다. 
			System.out.println("같음");
		else 
			System.out.println("다름");
	}
}
