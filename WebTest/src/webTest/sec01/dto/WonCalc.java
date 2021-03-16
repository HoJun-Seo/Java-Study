package webTest.sec01.dto;

public class WonCalc {

	private float USD_RATE = 1131.76F;
	private float JYP_RATE = 10.36F;
	private float CNY_RATE = 174.11F;
	private float GBP_RATE = 1564.75F;
	private float EUR_RATE = 1348.63F;
	
	public String calculate(float won, String op) {
		String result = "";
		if(op.equals("dollar")) {
			result = String.format("%.6f", won/USD_RATE);
		} else if(op.equals("en")) {
			result = String.format("%.6f", won/JYP_RATE);
		} else if(op.equals("wian")) {
			result = String.format("%.6f", won/CNY_RATE);
		} else if(op.equals("pound")) {
			result = String.format("%.6f", won/GBP_RATE);
		} else if(op.equals("euro")) {
			result = String.format("%.6f", won/EUR_RATE);
		}
		return result;
	}
}
