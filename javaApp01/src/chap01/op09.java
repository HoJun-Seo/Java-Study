package chap01;

import java.util.Scanner;

public class op09 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String msg = "";
		
		if(num > 0) {
			msg = "양수";
		} else if(num == 0){
			msg = "ZERO";
		} else {
			msg = "음수";
		}
		
		System.out.println(msg);
	}

}
