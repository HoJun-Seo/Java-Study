package InputOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipClass {

	public static void main(String[] args) {
		String sPath = "C:"+File.separator+"Users"+
				File.separator+"tnrdu"+File.separator+"Documents"
				+ File.separator + "GitHub" + File.separator + "Java-Study"
				+ File.separator + "App01" + File.separator;
		
		System.out.println(sPath);
		
		byte[] bytes = new byte[1024]; // 1MB = 1024Byte(블럭단위 읽기/쓰기)
		
		// 압축할 파일 목록
		String files[] = new File(sPath).list();
		Arrays.stream(files).forEach(x -> System.out.printf(" %s\n", x));
		
		try (FileOutputStream fos = new FileOutputStream(sPath + "test.zip");
				ZipOutputStream zos = new ZipOutputStream(fos)){
			
			Arrays.stream(files)
				.filter(x -> x.endsWith(".txt")) // ".txt" 으로 끝나는 문자열만 필터링
				.forEach(x -> {
					File f = new File(sPath + x); // 문자열 -> 파일시스템 으로 전환
					try (FileInputStream fis = new FileInputStream(f)){
						// 각각 파일을 읽어들임
						ZipEntry zipEntry = new ZipEntry(f.getName());
						zos.putNextEntry(zipEntry);
						
						int length;
						while((length = fis.read(bytes)) != -1) {
							zos.write(bytes, 0, length);
						}
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				});
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		/*
		String file = "test.txt";
		
		// 경로가 없으면 생성
		File p = new File(sPath);
		if(!p.exists()) {
			p.mkdirs();
		}
		
		// 파일 생성
		File f = new File(sPath+file);
		try {
			System.out.println("파일 생성 합니다." + f.getCanonicalPath());
			f.createNewFile();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
	}

}
