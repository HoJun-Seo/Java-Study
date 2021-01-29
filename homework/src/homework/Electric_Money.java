package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Electric_Money {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("전력 사용량을 입력하십시오(201 ~ 400kwh) : ");
		int electric_value = Integer.parseInt(br.readLine());
		
		electric_value -= 200;
		
		double electric_money = Math.floor(1600 + (200*93.3) + (electric_value * 187.9));
		long vat = Math.round(electric_money * 0.1);
		double electric_industry = Math.floor(electric_money * 0.037);
		electric_industry -= electric_industry % 10;
		
		int claim = (int) (electric_money + vat + electric_industry);
		claim -= claim % 10;
		
		System.out.println("청구금액 : " + claim + "원");
	}

}
