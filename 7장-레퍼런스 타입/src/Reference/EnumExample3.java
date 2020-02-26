package Reference;

public class EnumExample3 {
	public static void main(String[] args) {
		printSeason(Season.SPRING);
		printSeason(Season.SUMMER);
		printSeason(Season.FALL);
		printSeason(Season.WINTER);
	}
	static void printSeason(Season season) {
		System.out.println(season.value()); //Season 열거 타입에 선언한 value method 호출
	}
}
