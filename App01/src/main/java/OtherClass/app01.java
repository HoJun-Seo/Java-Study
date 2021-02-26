package OtherClass;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class app01 {

	public static void main(String[] args) {
		System.out.println("연월 정보를 입력하세요(yyyymm) : ");
		Scanner sc = new Scanner(System.in);
		String data = sc.next();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuuMMdd");
		LocalDate dt = LocalDate.parse(data+"01", formatter); // 연도+"01" 월에 대한 날짜 "01" 로 시작
		
		int dtMonth = dt.getMonthValue(); // 1 ~ 12 월
		System.out.println("연월에서 월만 추출 : " + dtMonth);
		int weekCnt = 0;
		
		int[][] days = new int[6][7]; // 6주 7일
		int day = 1;
		int weekNum = dt.getDayOfWeek().getValue(); // 1일의 요일
		System.out.println("요일을 숫자로 표현 : " + weekNum);
		do {
			days[weekCnt][weekNum] = dt.getDayOfMonth();
			System.out.println(dt.getDayOfMonth()); // 월에 대한 일(1일 부터 출발)
			
			if(weekNum == 6) {
				weekCnt++; // 한 주에 7일이 채워지면 다음주로 변환
				weekNum = 0;
			} else {
				weekNum++;
			}
			
			dt = dt.plusDays(day); // 1일 이후 일자 계산
			System.out.println("현재 월 : " + dt);
			System.out.println("-----");
		} while(dtMonth == dt.getMonthValue());
		
		// 출력 형식 작성
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(data);
		
		// cell 스타일 정의
		CellStyle stringStyle = workbook.createCellStyle();
		stringStyle.setAlignment(HorizontalAlignment.CENTER);
		stringStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		
		// row(행) 생성
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		
		cell.setCellStyle(stringStyle);
		cell.setCellValue(dt.getYear()+"년 " + dtMonth + " 월");
		
		cell = row.createCell(1);cell = row.createCell(2);cell = row.createCell(3);
		cell = row.createCell(4);cell = row.createCell(5);cell = row.createCell(6);
		
		// 셀 병합
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,6)); // 0행 0열부터 0행 6열 까지 병합
		
		// 요일 출력
		String[] weekName = {"SUN", "MON", "TUE", "WEZ", "THU", "FRI", "SAT"};
		row = sheet.createRow(2);
		for(int i = 0; i < 7; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(stringStyle);
			cell.setCellValue(weekName[i]);
		}
		
		// 1차원 : 열 단위 기본 => arr[0], arr[1], ...
		// 2차원 : 행 단위 기본 => arr[0], arr[1], ... 0행,1행,2행,...
		int r = 2;
		for(int[] week : days) { // 2차원은 행 단위만 적용, => 0행,1행,2행,...
			row = sheet.createRow(++r);
			int t = 0;
			for(int today : week) { // 1차원 배열 구조 : 1열, 2열
				cell = row.createCell(t++);
				cell.setCellStyle(stringStyle);
				cell.setCellValue("" + (today == 0 ? "" : today));
			}
		}
		
		// 엑셀파일 생성(작성)
		try (FileOutputStream out = new FileOutputStream(new File(dt.getYear() + "년 " + dtMonth + "월.xlsx"))){
			workbook.write(out);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("엑셀 파일이 작성 되었습니다.");
	}

}
