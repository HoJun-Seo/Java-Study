package webTest.sec01.dto;

public class BmiCalc {
	
	private String name;
	private double height;
	private double weight;
	private String result;
	
	public BmiCalc(String name, double height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}
	public String getResult() {
		return result;
	}
	
	public double bmiCalcProcess() {
		double bmi = weight / ((height/100) * (height/100));
		if(bmi <= 18.5) {
			result = "저체중";
			
		} else if(bmi > 18.5 && bmi <= 23) {
			result = "정상";
		} else if(bmi >23 && bmi <= 25) {
			result = "과체중";
		} else if(bmi > 25 && bmi <= 30) {
			result = "고도비만";
		}
		
		return bmi;
	}
}
