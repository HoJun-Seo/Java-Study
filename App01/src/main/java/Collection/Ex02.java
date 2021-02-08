package Collection;

import java.util.Stack;

public class Ex02 {
	public static void main(String[] args) {
		String ant_number = "1";
		Stack<Integer> ant_list = new Stack<Integer>();
		int count = 0;
		
		while(count < 10) {
			int[] ant_array = new int[ant_number.length()];
			for(int i = 0; i < ant_array.length; i++) {
				ant_array[i] = Character.getNumericValue(ant_number.charAt(i));
			}
			ant_number = "";
			
			if(ant_array.length == 1) {
				ant_number = String.valueOf(ant_array[0])+"1";
				System.out.println(ant_number);
			}
			else {
				ant_list.push(ant_array[0]);
				for(int i = 1; i < ant_array.length; i++) {
					if(ant_list.peek() == ant_array[i] && i < ant_array.length-1) {
						ant_list.push(ant_array[i]);
					}
					else if(ant_list.peek() == ant_array[i] && i == ant_array.length-1) {
						ant_list.push(ant_array[i]);
						ant_number = string_concat(ant_list, ant_number);
					}
					else if(ant_list.peek() != ant_array[i] && i < ant_array.length-1){
						ant_number = string_concat(ant_list, ant_number);
						ant_list.push(ant_array[i]);
					}
					else {
						ant_number = string_concat(ant_list, ant_number);
						ant_list.push(ant_array[i]);
						ant_number = string_concat(ant_list, ant_number);
					}
				}
				System.out.println(ant_number);
			}
			count++;
		}
	}
	
	public static String string_concat(Stack<Integer> ant_list, String ant_number) {
		ant_number += String.valueOf(ant_list.peek())+String.valueOf(ant_list.size());
		ant_list.clear();
		return ant_number;
	}
}
