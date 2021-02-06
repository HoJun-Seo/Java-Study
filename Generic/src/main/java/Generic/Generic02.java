package Generic;

import lombok.Getter;

public class Generic02 {

	public static void main(String[] args) {
		CustomList<String> str_array = new CustomList<>("String", 5);
		str_array.add("서호준");
		str_array.add("서호진");
		str_array.add("서호정");
		for(String str : str_array.getArray()) {
			System.out.println(str);
		}
		
		System.out.println("----------------");
		
		CustomList<Integer> int_array = new CustomList<>("Integer", 10);
		for(int i = 0; i < 10; i++) {
			int_array.add(i);
		}
		for(int number : int_array.getArray()) {
			System.out.println(number);
		}
	}

}

@Getter
class CustomList<T> {
	
	private T[] array;
	
	public CustomList(String type, int arr_length) {
		if(type == "String")
			array = (T[]) new String[arr_length];
		else if(type == "Integer")
			array = (T[]) new Integer[arr_length];
	}

	public void add(T t) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				array[i] = t;
				break;
			}
		}
	}
}
