package io;

import java.util.Scanner;
/*
 * 	typedef struct scanner{
 * 	
 * }Scanner;
 * int main(){
 * 	Scanner sc = (Scanner*)malloc(sizeof(Scanner));
 * }
 * -> == Scanner sc = new Scanner(System.in);
 */
public class ex02_Scanner {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int age;
		double height;
		
		System.out.print("이름 입력 : ");
		name = sc.nextLine();//string 자료형을 반환하는 함수(nextLine)
		
		System.out.println("나이 입력 : ");
		age = Integer.parseInt(sc.nextLine()); //wrapper class 활용
						//int 자료형을 반환하는 함수(parseInt)
		
		System.out.println("키 입력 : ");
		height = Double.parseDouble(sc.nextLine());//double 자료형을 반환하는 함수(parseDouble)
		
		System.out.println(name + "님의 나이는 만으로 " + (age-1) + "살 입니다.");//반환하는 자료형이 없는 함수 : println(void형)
		System.out.println(name + "님의 키는 " + height + "cm 입니다.");
		
		System.out.println(); //한 줄 내림
		
		System.out.printf("%s 님의 나이는 %d 살이고, 키는 %.2fcm 입니다.\n", name, age, height);
		
		//서식을 지정한다.
		String format = "%s님의 나이는 %d 살이고, 키는 %.2fcm 입니다.\n";
		
		//서식과 값을 이용해서 결과 데이터를 result 에 저장한다.
		String result = String.format(format, name, age, height); //result 에 저장한 문자열을 다른 함수에 넘겨 줄수 있다.
		
		//그냥 출력
		System.out.println(result);
		
		
		//함수 위에 마우스를 올려 놓으면 함수에 대한 정보를 발견할 수 있는데
		//해당 정보 창에서 해당하는 함수의 반환형과 같은 자세한 정보를 확인 할 수 있다.
	}
}
