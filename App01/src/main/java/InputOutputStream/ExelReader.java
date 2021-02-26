package InputOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelReader {

	public static void main(String[] args) {
		List list = new ArrayList<String>();
		
		// new File("") -> 익명 클래스 역할
		try (FileInputStream in = new FileInputStream(new File("점수2.xlsx"))){
			
			XSSFWorkbook workbook = new XSSFWorkbook(in);
			XSSFSheet sheet = workbook.getSheet("1학년1반");
			
			// sheet 로부터 데이터가 있는 모든 Row 읽기
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.forEachRemaining(row -> {
				//Row 에 있는 모든 Cell 정보를 Iterator 정보로 읽기
				Iterator<Cell> cellIterator = row.cellIterator();
				// Cell 에 있는 데이터를 읽어와서 처리
				// 학번, 이름, 시험일자, 국어, 영어, 수학 데이터를 HashMap 에 보관
				var data = new HashMap<String, Object>();
				data.put("학번", row.getCell(0).getStringCellValue());
				data.put("이름", row.getCell(1).getStringCellValue());
				data.put("시험일자", row.getCell(2).getStringCellValue());
				data.put("국어", row.getCell(3).getStringCellValue());
				data.put("영어", row.getCell(4).getStringCellValue());
				data.put("수학", row.getCell(5).getStringCellValue());
				
				list.add(data);
				
			}); // rowIterator
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println(list.toString());
	}

}
