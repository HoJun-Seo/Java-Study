package board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private int num;  
	private String writer;  
	private String subject;
	private String passwd;  
	private Date reg_date; 
	private int readcount;
	private String content;    

	private int ref;       
	private int re_step;     
	private int re_level;    

	private String ip;          
	private String filename; // abc.txt 
	private int filesize; 
	private int down;
	
	// db에서 계산된 필드를 담아오는 멤버 변수
	private int comment_count;
	private int rn;
	
	// 추가 : 파일 확장자(실행파일 추출 : 악성코드 예방)
	private String ext; // "txt"

	@Override
	public String toString() {
		return "BoardDTO [num=" + num + ", writer=" + writer + ", subject=" + subject + ", passwd=" + passwd
				+ ", reg_date=" + reg_date + ", readcount=" + readcount + ", content=" + content + ", ref=" + ref
				+ ", re_step=" + re_step + ", re_level=" + re_level + ", ip=" + ip + ", filename=" + filename
				+ ", filesize=" + filesize + ", down=" + down + ", ext=" + ext + "]";
	}
	
	

}
