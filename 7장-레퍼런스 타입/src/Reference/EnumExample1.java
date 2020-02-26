package Reference;

public class EnumExample1 {
	public static void main(String[] args) {
		Day days[] = Day.values(); //values method 를 호출하면 열거상수 들이 배열에 담겨져서 리턴된다.
		for(Day day : days)
			System.out.println(day);
	}
}
