package Object;
/*
 * 우리가 직접 작성한 클래스도(GoodsStock class 의 경우) Object class 의 서브 클래스이기 때문에 toStirng method 를 상속 받는다.
 */
public class ObjectExample2 {
	public static void main(String[] args) {
		GoodsStock obj = new GoodsStock("57293", 100);
		String str = obj.toString();
		System.out.println(str);
		/*
		 * 이 프로그램의 실행으로 얻을 수 있는 결과는 Object class 의 toString method 가 리턴하는 문자열인데
		 * 이 값은 우리가 일반적으로 기대 할 수 있는 상품재고 정보와는 거리가 멀다(Object.GoodsStock@15db9742 와 같은 결과가 나온다.)
		 * GoodsStock class 의 필드 값이 출력된다면 좀 더 의미 있는 결과값이 될 수 있다.
		 * 그렇게 하기 위해서는 Object class 로 부터 상속 받은 toString method 를 GoodsStock class 에서 오버라이드(다시 선언)해야 한다.
		 * - 현재 Object package 내의 GoodsStock class 참조
		 */
	}
}
