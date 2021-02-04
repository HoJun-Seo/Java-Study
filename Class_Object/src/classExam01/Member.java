package classExam01;

public class Member {
	
	private String name;
	private String userid;
	private int money;
	private String grade;
	
	public Member(String name, String userid, int money) {
		this.name = name;
		this.userid = userid;
		this.money = money;
	}

	public void setInput(String name, String userid, int money) {
		this.name = name;
		this.userid = userid;
		this.money = money;
	}
	
	public void setGrade() {
		if(money >= 100000) {
			grade = "골드회원";
		} else {
			grade = "실버회원";
		}
	}
	
	
}
