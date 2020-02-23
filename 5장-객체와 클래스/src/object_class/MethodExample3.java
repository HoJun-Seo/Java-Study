package object_class;

public class MethodExample3 {
	public static void main(String[] args) {
		int arr[] = new int[0]; //길이가 0 인 배열을 생성 - ArithmeticException 익셉션 발생
		Numbers obj = new Numbers(arr);
		try {
			int average = obj.getAverage(); //getAverage 메소드 내부에서 익셉션 발생 - 익셉션 밖으로 던져짐
			System.out.println("평균 = " + average);
		}
		catch(java.lang.ArithmeticException e) {
			System.out.println("평균을 계산하는 도중 오류가 발생하였습니다.");
		}//메소드 밖으로 던져지는 익셉션을 처리하기 위해 try catch 문을 사용한다.
	}
}
