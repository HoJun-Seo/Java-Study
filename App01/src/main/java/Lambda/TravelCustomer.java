package Lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TravelCustomer {

	private String name;
	private int age;
	private int price;
	
	@Override
	public String toString() {
		return "name : " + name + " age : " + age + 
				" price : " + price;
	}
}
