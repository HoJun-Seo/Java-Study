package access_control;
//private 키워드 : 해당 키워드가 붙은 필드, 메소드, 생성자는 해당 클래스 내부에서만 사용 가능하다.
public class Fraction {
	private int numerator;
	private int denominator;
	Fraction(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}
	private double getDouble() {
		return (double)numerator / denominator;
	}
	int getInt() {
		return (int)getDouble();
	}
}
