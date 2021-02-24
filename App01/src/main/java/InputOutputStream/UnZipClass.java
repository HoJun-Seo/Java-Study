package InputOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZipClass {

	public static void main(String[] args) {
		String sPath = "C:"+File.separator+"Users"+
				File.separator+"tnrdu"+File.separator+"Documents"
				+ File.separator + "GitHub" + File.separator + "Java-Study"
				+ File.separator + "App01" + File.separator;
		
		System.out.println(sPath);
		
		String files[] = new File(sPath).list();
		
		Arrays.stream(files)
			.filter(x -> {
				String[] ext = x.split("\\.");
				if(ext.length == 2 && "zip".equals(ext[1])) {
					return true;
				} return false;
			})
			.forEach(x -> {
				// 압축파일 이름과 동일한 이름으로 폴더 (디렉토리 생성)
				File zipPath = new File(sPath + x.split("\\.")[0]);
				zipPath.mkdir();
				
				try (ZipInputStream zis = new ZipInputStream(new FileInputStream(sPath+x))){
					
					ZipEntry zipentry = null;
					while((zipentry = zis.getNextEntry()) != null) {
						
						// 압축 파일 요소 경로
						String entryFile = sPath + x.split("\\.")[0] +
								File.separator + zipentry.getName();
						
						try (FileOutputStream fos = new FileOutputStream(entryFile)){
							
							byte[] bytes = new byte[1024];
							int length;
							while((length = zis.read(bytes)) >= 0) {
								fos.write(bytes,0,length);
							}
						}catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			});

	}

}
