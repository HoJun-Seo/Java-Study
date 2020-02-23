package object_class;

public class StaticMethodExample1 {
	public static void main(String[] args) {
		Accumulator obj1 = new Accumulator();
		Accumulator obj2 = new Accumulator();
		obj1.accumulate(10);
		obj2.accumulate(20);
		int grandTotal = Accumulator.getGrandTotal(); //정적 메소드 호출 - 객체를 생성해서 데이터를 저장할 필요가 없음
		System.out.println("obj1.total = " + obj1.total);
		System.out.println("obj1.total = " + obj2.total);
		System.out.println("총계 = " + grandTotal);
	}
}
