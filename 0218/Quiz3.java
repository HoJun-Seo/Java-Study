package dataType;

public class Quiz3 {
	public static void main(String[] args) {
		//wrapper class 사용해보기
		String name = "서호준";
		Integer age = 25;
		Double dou = (double)0; //초기화
		dou = 3.14; //대입
		Float flo = (float)(double)dou;
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(dou);
		System.out.println(flo);
	}
}
