package classExam02;

public class ProductInherit {
	private int code;//제품코드
	private String name;// 제품명
	private String company;// 제조사
	private String date;// 제조일자
	
	// setter,getter
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public ProductInherit(int code, String name, String company, String date) {
		this.code = code;
		this.name = name;
		this.company = company;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
