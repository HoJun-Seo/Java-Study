package ex06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductVo {
	
	private String productNo;
	private String productName;
	private int price;
	private boolean checkYn;
	private String productCode;
}
