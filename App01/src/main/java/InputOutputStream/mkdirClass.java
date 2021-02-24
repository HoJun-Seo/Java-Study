package InputOutputStream;

import java.io.File;

public class mkdirClass {

	public static void main(String[] args) {
		String sPath = "C:"+File.separator+"myjava"+
				File.separator+"javawork"+File.separator+"App01"+File.separator;
		
		System.out.println(sPath);
		
		String file = "test.txt";
		
		// 경로가 없으면 생성
		File p = new File(sPath);
		if (!p.exists()) {
			p.mkdirs();
		}
		
		// 파일 생성
		File f = new File(sPath+file);
		try {
			System.out.println("파일 생성 합니다."+f.getCanonicalPath());
			f.createNewFile();
			System.out.println(f.exists());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
