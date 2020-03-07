package Object;
/*
 * toString method 는 때때로 우리가 인식하지 못하는 부분에서 자동으로 호출된다.
 * 예를 들어 문자열과 다른 종류의 객체를 + 연산자로 연결하면 그 객체의  toString method 가 자동으로 호출된 후에 문자열이 연결된다.
 * 이러한 특징으로 인해 아래와 같은 두 코드는 똑같은 효과를 갖게된다.
 * 1) File file = new File("C:\\독수리"); String str = "경로명 : " + file;
 * 2) File file = new File("C:\\독수리"); String str = "경로명 : " + file.toString();
 */
public class ObjectExample3 {
	public static void main(String[] args) {
		GoodsStock obj = new GoodsStock("57293", 100);
		String str = "재고 정보 = " + obj; //문자열과 GoodsStock 객체를 + 연산자로 연결한다.
		//toString method 가 자동으로 호출됨
		//GoodsStock class 에 toString method 를 오버라이드 해놓은 상태이기 때문에 정상적인 출력값을 얻을 수 있다.\
		System.out.println(str);
	}
}
