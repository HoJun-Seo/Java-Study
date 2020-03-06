package File;

import java.io.File;
import java.util.GregorianCalendar;
/*
 * File class 에는 파일과 디렉토리에 대한 아래와 같은 정보를 가져올 수 있는 메소드 들이 있다.
 * 1. 파일의 크기, 2. 파일의 이름(또는 디렉토리의 이름), 3. 최종 수정일시, 4. 읽기 가능/쓰기 가능/숨김파일 여부
 * File 객체를 생성할 때 반드시 파일이나 디렉토리의 경로명을 파라미터로 넘겨줘야 한다. 그래야 정보를 얻을 파일이나 디렉토리가 어느것인지 알 수 있기 때문이다.
 * 예) File file = new File("poem.txt"); - 현재 디렉토리에 있는 poem.txt 에 대한 File 객체를 생성한다.
 * 예) File file = new File("C:\\work\\chap10"); - C 드라이브의 work 디렉토리 아래에 있는 chap10 에 대한 File 객체를 생성한다.
 * File 객체 안에는 파라미터로 넘겨진 경로명이 저장되지만, File class 는 파일의 내용을 다루는 클래스가 아니기 때문에 File 객체를 생성한다고 해서
 * 해당 파일이 열리는 것이 아니다. - File 객체를 생성할 때는 해당 파일이나 디렉토리가 있는지조차 검사하지 않는다.
 * 그렇기 때문에 파일이나 디렉토리가 있는지 알려면 exists 라는 메소드를 호출해야 한다. - Boolean isThere = file.exists(); : 파일 또는 디렉토리가 있으면 true, 없으면 false 를 리턴
 * 때로는 생성자 파라미터로 넘겨준 경로명이 파일인지 디렉토리 인지 알고 싶을때는 isFile 이나 isDirectory method 를 사용하면 된다. - 파일 또는 디렉토리면 true, 아니면 false 를 리턴
 * 
 * 파일이나 디렉토리가 존재한다는 사실을 확인했으면 그 다음에는 File class 의 다음 메소드를 호출해서 파일 또는 디렉토리에 대한 정보를 알아낼 수 있다.
 * String name = file.getName(); - 이름을 리턴
 * long size = file.length(); - 크기를 리턴
 * long time = file.lastModified(); - 최종 수정일시를 리턴
 * boolean readMode = file.canRead(); - 읽기 가능 여부를 리턴
 * boolean writeMode = file.canWrite(); - 쓰기 가능 여부를 리턴
 * boolean hiddenMode = file.isHidden(); - 숨김 여부를 리턴
 * String parent = file.getParent(); - 부모 디렉토리 경로명을 리턴
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
			/*
			 * length method 는 파일의 크기를 리턴하는 메소드인데, 디렉토리에 사용할 때는 의미없는 값을 리턴한다.
			 * 이와는 반대로 listFiles 라는 method 는 디렉토리에 대해 사용할 때만 의미 있는 값을 리턴하는 메소드이다.
			 * listFiles method 는 디렉토리에 속하는 파일과 서브 디렉토리의 리스트를 File 배열로 리턴한다.
			 */
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
