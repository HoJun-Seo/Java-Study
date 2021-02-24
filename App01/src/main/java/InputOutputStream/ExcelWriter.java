package InputOutputStream;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	public static void main(String[] args) {
		
		// 엑셀 workbook 생성
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// 엑셀 sheet 생성
		XSSFSheet sheet = workbook.createSheet();
		
		// row 생성
		Row row = sheet.createRow(0);
		
		// cell 생성
		Cell cell;
		cell = row.createCell(0);
		cell.setCellValue("학번");
		cell = row.createCell(1);
		cell.setCellValue("이름");
		cell = row.createCell(2);
		cell.setCellValue("국어");
		cell = row.createCell(3);
		cell.setCellValue("영어");
		cell = row.createCell(4);
		cell.setCellValue("수학");
		
		// 엑셀 파일 생성
		try (FileOutputStream out = new FileOutputStream(new File("성적.xlsx"))){
			workbook.write(out);
			System.out.println("엑셀 파일이 작성되었습니다.");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
