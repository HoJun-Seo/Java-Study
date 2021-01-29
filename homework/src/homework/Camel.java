package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Camel {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("문자열 입력 : ");
		String[] camel_array = br.readLine().toLowerCase().split(" ");
		String camel = "";
		
		for(int i = 1; i < camel_array.length; i++) {
			if(camel_array[i].charAt(0) >= 97 && camel_array[i].charAt(0) <= 122) {
				char[] camel_ch = camel_array[i].toCharArray();
				camel_ch[0] = (char)(camel_ch[0] - 32);
				camel_array[i] = String.valueOf(camel_ch);
			}
		}
		
		for(String str : camel_array) {
			camel += str;
		}
		System.out.println("카멜 표기법 변환 : " + camel);
	}
}
