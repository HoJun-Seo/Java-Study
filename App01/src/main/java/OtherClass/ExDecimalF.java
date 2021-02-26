package OtherClass;

import java.text.DecimalFormat;

public class ExDecimalF {

	public static void main(String[] args) {
		DecimalFormat df1 = new DecimalFormat("###,###.##");
		DecimalFormat df2 = new DecimalFormat("000,000.00");
		
		System.out.println(df1.format(5000.789));
		System.out.println(df1.format(5000));
		
		System.out.println("----");
		System.out.println(df2.format(5000.789));
		System.out.println(df2.format(5000));
	}

}
