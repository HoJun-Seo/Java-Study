package Generic;



import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Integer 데이터 입력");
		Number_List<Integer> fi = new Number_List<>(sc.nextInt(), sc.nextInt());
		
		if(fi.validate()) {
			fi.fibonacci(fi.getStart(), fi.getCount());
		}
			
		else {
			System.out.println("0 이 입력되었습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		
		System.out.println("=======================");
		System.out.println("Long 데이터 입력");
		
		Number_List<Long> fi_long = new Number_List<>(sc.nextLong(), sc.nextInt());
		
		if(fi_long.validate()) {
			fi_long.fibonacci(fi_long.getStart(), fi_long.getCount());
		}
			
		else {
			System.out.println("0 이 입력되었습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}
		
		System.out.println("=======================");
		System.out.println("Double 데이터 입력");
		
		Number_List<Double> fi_double = new Number_List<>(sc.nextDouble(), sc.nextInt());
		
		if(fi_double.validate()) {
			fi_double.fibonacci(fi_double.getStart(), fi_double.getCount());
		}
			
		else {
			System.out.println("0 이 입력되었습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		}
	}
}


@Getter
@AllArgsConstructor
class Number_List<T extends Number>{
	private T start;
	private int count;
	
	public boolean validate() {
		if(start.equals(0) || count == 0) return false;	
		else return true;
	}
	
	public void fibonacci(T start, int count) {
		System.out.print(start + " " + start + " ");
		if(start.getClass() == Integer.class) {
			int start_number = start.intValue();
			int result = start_number * 2;
			
			for(int i = 3; i <= count; i++ ) {
				System.out.print(result + " ");
				int temp = result;
				result += start_number;
				start_number = temp;
			}
		} 
		else if(start.getClass() == Long.class) {
			long start_number = start.longValue();
			long result = start_number * 2;
			
			for(int i = 3; i <= count; i++ ) {
				System.out.print(result + " ");
				long temp = result;
				result += start_number;
				start_number = temp;
			}
		}
		else if(start.getClass() == Double.class) {
			double start_number = start.doubleValue();
			double result = start_number * 2;
			
			for(int i = 3; i <= count; i++ ) {
				System.out.print(result + " ");
				double temp = result;
				result += start_number;
				start_number = temp;
			}
		}
		
		System.out.println();
	}
}
