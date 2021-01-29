package chap01;

import java.util.Arrays;

public class arr09 {

	public static void main(String[] args) {
		
		int[] num1 = new int[] {10,9,8,7,6,5,4,3,2,1};
		
		int[] num2 = Arrays.copyOf(num1, num1.length);
		int[] num3 = Arrays.copyOf(num1, num1.length-1);
		int[] num4 = Arrays.copyOf(num1, num1.length-2);
		int[] num5 = Arrays.copyOf(num1, num1.length-3);
		int[] num6 = Arrays.copyOf(num1, num1.length-4);
		
		System.out.println(Arrays.toString(num1));
		System.out.println(Arrays.toString(num2));
		System.out.println(Arrays.toString(num3));
		System.out.println(Arrays.toString(num4));
		System.out.println(Arrays.toString(num5));
		System.out.println(Arrays.toString(num6));
		
		int[] num7 = Arrays.copyOfRange(num1, 2, num1.length);
		System.out.println(Arrays.toString(num7));
		
		System.out.println("---------------");
		System.out.println(Arrays.toString(num1));
		
		Arrays.sort(num1);
 		System.out.println(Arrays.toString(num1));
		
	}

}
