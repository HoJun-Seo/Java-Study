package dataType;
//자료형 변환
//promotion - 자동, 또는 암묵적 형 변환
//casting - 강제, 또는 명시적 형 변환
public class Ex02_TypeCasting {
	public static void main(String[] args) {
		byte by = 10;
		short sh = 20;
		char ch = 65;
		int num = 30;
		long lo = 40L;
		float fl = 3.14F;
		double db = 11.56;
		
		int a = by; //promotion
		char b = (char)db; //casting(자료형의 크기가 다른 경우)-값의 손실이 있을수 있다.
		long c = sh; //promotion
		float d = num; //promotion
		short e = (short)ch; //casting(자료형의 크기는 같으나 표현 범위가 다른 경우)- short : 부호 표시 있음, char : 부호 표시 없음
		double f = by; //promotion
	}
}
