package File;

import java.io.File;
import java.util.GregorianCalendar;
/*
 * File class 에는 파일과 디렉토리에 대한 아래와 같은 정보를 가져올 수 있는 메소드 들이 있다.
 * 1. 파일의 크기, 2. 파일의 이름(또는 디렉토리의 이름), 3. 최종 수정일시, 4. 읽기 가능/쓰기 가능/숨김파일 여부
 */
public class FileExample1 {
	public static void main(String[] args) {
		File file = new File("."); //현재 디렉토리의 경로면을 가지고 File 객체를 생성한다.
		File arr[] = file.listFiles(); //서브 디렉토리와 파일 목록을 가져온다. File 배열에 리턴받음
		for(int cnt = 0; cnt < arr.length; cnt++) {
			String name = arr[cnt].getName();
			if(arr[cnt].isFile())
				System.out.printf("%-25s %7d ", name, arr[cnt].length());
			//가져온 서브디렉토리와 파일의 이름, 크기 등을 출력한다.
			else
				System.out.printf("%-25s     <DIR>  ", name);
			long time = arr[cnt].lastModified();
			GregorianCalendar calendar = new GregorianCalendar();
			calendar.setTimeInMillis(time);
			//GregorianCalendar class 의 setTimeInMillis method 는 객체가 가지고 있는 시각 정보를 파라미터 값으로 갱신하는 메소드이다.
			//이 때 파라미터는 1970년 1월 1일 0시 0분 0초 를 기점으로 경과한 밀리세컨드 값이어야 한다.
			System.out.printf("%1$tF %1$tT \n", calendar); //calendar 객체가 가지고 있는 시각 정보를 YYYY-MM-DD HH:MM:SS 포맷으로 출력한다.
			//가져온 서브 디렉토리와 파일의 최종 수정일시를 출력한다.
		}
	}
}
