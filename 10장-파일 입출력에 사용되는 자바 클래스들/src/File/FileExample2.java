package File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/*
 * File class 를 이용해서 파일을 생성하고 삭제하는 방법 - File class 에 있는 메소드 중에서 createNewFile 메소드는 파일을 생성하는 메소드이고, delete 메소드는 파일을 삭제하는 메소드이다.
 * 예) File file1 = new File("poem.txt"); file1.createNewFile(); - 현재 디렉토리에 poem.txt 라는 이름의 파일을 생성한다.
 * 예) File file2 = new File("C:\\doc\\회의록.hwp"); file2.delete(); - C:\doc\회의록.hwp 파일을 삭제한다.
 * mkdir 메소드는 새로운 디렉토리를 생성하는 메소드이다. 디렉토리를 삭제 할 때는 파일과 마찬가지로 delete method 를 사용해야 한다.
 * 예) File file1 = new File("C:\\올빼미"); file1.mkdir(); - C 드라이브의 루트 디렉토리에 "올빼미" 라는 디렉토리를 생성한다.
 * 예) File file2 = new File("두루미"); file2.delete(); - 현재 디렉토리에 있는 "두루미" 라는 디렉토리를 삭제한다.
 * 새로운 파일이나 디렉토리를 생성할 때는 그 경로명을 갖는 File 객체를 먼저 생성해야 하지만, 때로는 생성하는 파일의 이름이 중요하지 않을 때가 있다.
 * 예를 들어 프로그램 실행 중에 데이터를 잠시 저장해 둘 임시 파일(temporary file)의 경우가 그렇다.
 * 그럴 때는 File class 의 createTempFile method 를 사용하면 된다. 이 메소드는 임시 파일을 만드는데 사용되는 메소드이며 
 * createNewFile method 와는 달리 정적 메소드이기 때문에 File 객체를 생성하지 않고도 호출 할 수 있다.
 * 파라미터로는 파일 이름의 일부만 넘겨주면 된다. - File tmpFile = file.createTempFile("tmp", ".txt", tmpDir); - tmp 로 시작하고, .txt 로 끝나는 임시파일을 tmpDir 디렉토리에 생성한다.
 * createTempFile method 를 호출하면 이 메소드는 주어진 디렉토리 안에 주어진 문자열로 시작하고 끝나는 파일을 다른 파일 이름과 중복되지 않게 생성한다.
 * 그러고 나서 생성된 파일의 정보를 File 객체로 만들어서 리턴한다.
 */
public class FileExample2 {
	public static void main(String[] args) {
		FileWriter writer = null;
		try {
			File file = File.createTempFile("tmp", ".txt", new File("C:\\temp"));
			//임시 파일을 생성한다.
			writer = new FileWriter(file);
			/*
			 * createTempFile method 가 리턴하는 파일은 열려있는 상태가 아니기 때문에 어떤 내용을 쓰기 위해서는
			 * 앞에서 사용한 FileWriter, FileOutputStream, PrintWriter class 중 하나를 이용해서 파일을 열어야 한다.
			 * 파일 출력의 기능을 갖는 위와 같은 클래스들은 대개 File 타입의 파라미터를 받는 생성자를 갖고 있기 때문에, 이 경우에는 그런 생성자를 이용해서 파일을 여는 것이 편리하다.
			 * 임시 파일은 프로그램에서 사용하고 난 다음에 바로 삭제하기도 하지만, 이 프로그램에서는 실행 결과를 확인 할 수 있도록 하기 위해
			 * 삭제하는 명령문은 넣지 않았다.
			 */
			writer.write('자');
			writer.write('바');
			//임시 파일을 열어서 데이터를 쓴다.
		}
		catch(IOException ioe) {
			System.out.println("임시 파일에 쓸 수 없습니다.");
		}
		finally {
			try {
				writer.close();
			}
			catch(Exception e) {
			}
		}
	}
}
