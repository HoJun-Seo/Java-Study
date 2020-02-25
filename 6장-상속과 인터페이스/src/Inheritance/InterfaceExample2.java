package Inheritance;

public class InterfaceExample2 {
	public static void main(String[] args) throws Exception {
		Lendable arr[] = new Lendable[3]; //인터페이스 타입의 배열
		arr[0] = new SeperateVolume("883ㅇ326ㅍ2", "푸코의 진자", "에코");
		arr[1] = new SeperateVolume("609.2ㄱ428ㅅ", "서양 미술사", "곰브리치");
		arr[2] = new AppCDInfo("2002-1742", "XML을 위한 자바 프로그래밍");
		//배열에 여러 타입의 객체 저장 - 인터페이스 변수는 다형성의 성질을 가지고 있기 때문에 여러 타입의 객체들을 대입 시킬수 있다.
		checkOutAll(arr, "윤지혜", "20060315"); //배열을 파라미터로 넘겨준다.
	}
	static void checkOutAll(Lendable arr[], String borrower, String date) throws Exception {
		for(int cnt = 0; cnt < arr.length; cnt++)
			arr[cnt].checkOut(borrower, date); //배열의 모든 항목에 대해 checkOut method 호출
		//각 객체에 해당하는 checkOut method 를 호출한다.
	}
}
