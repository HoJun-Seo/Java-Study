package chap01;

import java.util.Arrays;

public class arr07 {

	public static void main(String[] args) {
		int[] num = {1,2,3};
		int[] num2 = new int[] {12,12,13};
		int[] num3 = new int[3];
		num3[0] = 15; num3[1] = 25; num3[2] = 35;
		
		System.out.println("num 배열 내용 : " + num);
		System.out.println("num 배열 내용 : " + Arrays.toString(num));
		System.out.println("num 배열 내용 : " + Arrays.toString(num2));
		System.out.println("num 배열 내용 : " + Arrays.toString(num3));
		
		int[][] arrNum = {{1,2},{3,4},{5,6}};
		System.out.println(arrNum);
		System.out.println("arrNum 2차원 배열 내용 : " + Arrays.toString(arrNum));
		System.out.println("arrNum 2차원 배열 내용 : " + Arrays.deepToString(arrNum));
	}

}
