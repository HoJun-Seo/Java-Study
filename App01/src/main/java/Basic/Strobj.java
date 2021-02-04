package Basic;

public class Strobj {
	public static void main(String[] args) {
		//StringBuffer => StringBuilder : 버퍼가 있으면 가공
		StringBuffer strb = new StringBuffer("java android");
		System.out.println(strb);
		strb.append("자바");
		System.out.println(strb);
	}
}
