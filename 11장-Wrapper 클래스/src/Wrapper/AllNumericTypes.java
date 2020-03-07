package Wrapper;
/*
 * 수치를 표현하는 Byte, Short 등의 클래스에는 객체가 가지고 있는 값을 다른 타입의 값으로 변환하여 리턴하는 Value method 도 있다.
 * 이 과정에서 표현 범위가 더 작은 타입의 값으로 변환되면 데이터의 손실이 발생 할 수 있다.
 */
public class AllNumericTypes {
	public static void main(String[] args) {
		Float obj = new Float(10.5f);
		byte num1 = obj.byteValue(); //byte 타입의 10을 리턴
		short num2 = obj.shortValue(); //short 타입의 10을 리턴
		int num3 = obj.intValue(); //int 타입의 10을 리턴
		long num4 = obj.longValue(); //long 타입의 10을 리턴
		float num5 = obj.longValue(); //float 타입의 10을 리턴
		double num6 = obj.doubleValue(); //double 타입의 10을 리턴
	}
}
