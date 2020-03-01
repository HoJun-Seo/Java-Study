package File;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//primitive type 의 데이터를 입출력하는 클래스
//primitive type 의 데이터를 파일로 출력하기 - DataOutputStream class
/*
 * 프리미티브 타입읲 데이터를 바이트 스트림으로 만들어서 출력하는 기능의 클래스로, 파일에 데이터를 직접 쓰는 기능은 없기 때문에 
 * FileOutputStream class 와 함께 사용해야만 프리미티브 타입의 데이터를 파일에 쓸 수 있다.
 * 이 두 클래스를 함께 사용하기 위해서는 먼저 FileOutputStream 객체를 생성한 다음에 그 객체를 생성자 파라미터로 삼아서
 * DataOutputStream 객체를 생성해야 한다.
 */
public class DataOutputExample1 {
	public static void main(String[] args) {
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new FileOutputStream("output1.dat"));
			//FileOutputStream 객체를 DateOutputStream 객체의 파라미터로 넘겨준다.
			//사전에 FileOutputStream 객체를 생성해줄 필요 없이 DataoutputStream 객체를 생성할때 
			//new FileOutputStream("파일명") 형식으로 파라미터를 넘겨주는 방식으로 코드 작성이 가능하다.
			//이렇게 DataOutputStream 객체를 생성하면 그 안에 FileOutputStream 객체의 참조값이 저장된다.
			int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			for(int cnt = 0; cnt < arr.length; cnt++)
				out.writeInt(arr[cnt]);
			/*
			 * 생성된 DataOutputStream 객체에 위와 같은 writeInt method 를 호출하면 프리미티브 타입의 데이터를 출력할 수 있다.
			 * 예)void writeInt(int v) : 파라미터로 주어진 int 타입의 값을 출력하는 메소드
			 * 위와 같은 메소드들은 내부적으로 파라미터로 받은 데이터를 바이트로 분할한 다음에, 그 바이트 수만큼 FileOutputStream의
			 * wrtie method 를 호출해서 파일에 데이터를 쓴다.
			 * 예를 들어, writeInt method 는 int 타입 파라미터를 네 바이트로 분할한 후, FileOutputStream class 의 
			 * write method 를 네번 호출한다.
			 */
			
		}
		catch(IOException ioe) {
			System.out.println("파일로 출력 할 수 없습니다.");
		}
		finally {
			try {
				out.close();
				//DataOutputStream class 의 close method 는 내부적으로 FileOutputStream class 의 
				//close method 를 호출해서 파일을 닫는다.
			}
			catch(Exception e) {
			}
		}
	}
}
