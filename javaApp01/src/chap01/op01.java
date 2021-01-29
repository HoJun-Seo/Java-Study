package chap01;

public class op01 {
	public static void main(String[] args) {
		
//		String str1 = "홍길동";
		String str1 = new String("홍길동");
//		String str2 = "홍길동";
		String str2 = new String("홍길동");
		str1 = "홍길순";
		
		int a = 100;
		int b = 30;
		a = 10000;
		
		System.out.println(str1+","+str2);
		System.out.println(a+","+b);
	}
}
/*
 * 원래는 new 키워드를 사용하여 문자열 객체를 생성하는 것이 맞으나,
 * 일일히 다 그렇게 하면 귀찮기 때문에 String 객체에 한해서 단순 주입만으로 
 * 객체가 생성되도록 되어 있다.
 * (다른 객체는 생성할 때 전부 new 키워드를 사용해야 한다.)
 */
