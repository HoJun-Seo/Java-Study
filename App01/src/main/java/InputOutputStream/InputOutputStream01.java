package InputOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputOutputStream01 {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// 파일지칭 => 경로생성 => root 가 기본경로
			// root => 프로젝트가 root(기본경로)
			fis = new FileInputStream("pom.xml");
			fos = new FileOutputStream("output_pom.xml");
			
			int i;
			try {
				while((i = fis.read()) != -1) {
					fos.write(i);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 생성된 객체는 반드시 해제해야 한다.
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
