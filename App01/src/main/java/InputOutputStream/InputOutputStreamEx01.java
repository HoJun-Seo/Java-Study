package InputOutputStream;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.stream.IntStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import lombok.Getter;
import lombok.Setter;

public class InputOutputStreamEx01 {
	
	@Getter
	@Setter
	static String str = "";
	public static void main(String[] args) {
		
		IntStream.rangeClosed(2, 9)
			.forEach(x -> {
				IntStream.rangeClosed(1, 9)
					.forEach(y -> {
						// 각 단에 대한 곱을 반복 2*1 = 2 ..... 9*9 = 81
						setStr(getStr() + x + " x " + y + " = " + (x * y) + "\n");
					});
				
				System.out.println(x+".txt");
				// 구구단 결과 값 파일로 만들기
				System.out.println(getStr());
				// str 변수는 String 타입(char[]) => byte 타입으로 전환 => FileOutputStream 으로 보내기
				InputStream is = new ByteArrayInputStream(getStr().getBytes());
				
				// 각 단별로 파일을 생성
				try (FileOutputStream fw = new FileOutputStream(x + ".txt")){
					int i;
					while((i = is.read()) > -1) {
						fw.write(i);
					}
				}catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					File f = new File(x + ".txt");
					f.deleteOnExit();
					setStr(""); // str 변수 초기화
				}
			});
		
		// 압축하기
		try (FileOutputStream fos = new FileOutputStream("9x9.zip");
				ZipOutputStream zos = new ZipOutputStream(fos)){
			IntStream.rangeClosed(2, 9)
				.forEach(x -> {
					byte[] bytes = new byte[1024]; // 한번 읽기/쓰기 1024byte 단위
					
					File f = new File(x+".txt");
					
					// zip 파일의 output stream
					try (FileInputStream fis = new FileInputStream(f)){
						ZipEntry zipEntry = new ZipEntry(f.getName());
						zos.putNextEntry(zipEntry); // 압축할 파일에 등록(추가)
						
						int length;
						while((length = fis.read(bytes)) >= 0) {
							fos.write(bytes, 0, length);
						}
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				});
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
