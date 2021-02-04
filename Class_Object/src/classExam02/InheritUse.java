package classExam02;

public class InheritUse {

	public static void main(String[] args) {
		
		// 단일 클래스에서 초기화 작업
		Inherit01 in1 = new Inherit01();
		System.out.println(in1.toString());
		
		Inherit01 in2 = new Inherit01(100,200);
		System.out.println(in2.toString());
		
		System.out.println("================");
		
		Inherit02 in3 = new Inherit02();
	}

}
