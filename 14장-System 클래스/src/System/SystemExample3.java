package System;
/*
 * System class 의 out 필드는 PrintStream class 타입으로 선언되어 있다.
 * 그런데 out 필드 말고도 err 필드 또한 선언되어 있는데, 이 필드는 표준 에러 출력에 사용되는 필드이다. - 에러 메시지를 모니터로 보내는 출력
 * out 필드와 err 필드는 똑같은 방식으로 사용이 가능하다.
 * 프로그램에서 출력하는 일반 데이터와 에러 메시지가 섞여 혼란스러울 경우에는 err 필드와 out 필드의 용도를 구분해서 사용해 주는 것이 좋다.
 * 리눅스 또는 cmd 에서 해당 프로그램을 실행할 때 에러 메시지 만을 모니터에 출력하고 정상적인 출력은 파일에 저장하고 싶다면 java 프로그램명 이후에 > 기호를 사용하여 파일명을 붙여주면
 * 해당 파일에 정상적인 데이터가 출력되고 에러 메시지는 모니터에 따로 출력되게 된다.
 * 만약 반대로 정상적인 데이터를 모니터에 출력하고 에러 메시지는 파일에 출력하고 싶다면 > 대신 2> 을 사용한다.
 * > 와 2> 를 함께 사용하면 표준 출력과 표준 에러 출력의 방향을 모두 파일로 전환할 수도 있다.
 * 예) java SystemExample3 > output.txt 2> error.txt
 * 표준 입력도 표준 출력과 마찬가지로 방향을 전환할 수 있다. - 키보드로 입력받아야 할 문자들을 파일에 저장해 두었다가 프로그램의 표준 입력으로 사용하는 경우 < 기호를 사용한다.
 * 예) java SystemExample2 < input.txt - 명령행의 뒤쪽에 < 와 파일의 이름을 쓰면 System class 의 in 필드를 통해 그 파일의 내용이 프로그램에 출력된다.
 */
public class SystemExample3 {
	public static void main(String[] args) {
		int arr1[] = {77, 82, 99, 100, -27, 0, 42, -35, 60, 72};
		int arr2[] = {7, 0, 3, 0, -1, 2, 11, 5, 0, 9};
		for(int cnt = 0; cnt < arr1.length; cnt++) {
			try {
				int result = arr1[cnt] / arr2[cnt];
				System.out.printf("%d / %d = %d\n", arr1[cnt], arr2[cnt], result);
				//나눗셈의 정상적인 결과를 out 필드를 통해 출력한다.
			}
			catch(java.lang.ArithmeticException e) {
				System.err.println("잘못된 연산입니다. (index = " + cnt + ")");
				//나눗셈중 발생한 에러에 대한 메시지를 err 필드를 통해 출력한다.
			}
		}
	}
}
