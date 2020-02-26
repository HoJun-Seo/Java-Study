package Reference;

public class EnumExample2 {
	public static void main(String[] args) {
		printDay("MONDAY");
		printDay("WEDNESDAY");
		printDay("FRIDAY");
	}
	static void printDay(String name) {
		Day day = Day.valueOf(name); //valueOf method 는 열거 상수의 이름을 문자열로 넘겨주면 그에 해당하는 열거 상수를 리턴해주는 메소드이다.
		System.out.println(day);
	}
}
