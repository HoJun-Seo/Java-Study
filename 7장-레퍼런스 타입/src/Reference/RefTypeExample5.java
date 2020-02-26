package Reference;

public class RefTypeExample5 {
	public static void main(String[] args) {
		Point obj = null;
		if(obj == null) { //try-catch 문을 이용해 null 참조값으로 인한 NullPointerException 을 방지 할 수 있지만
							//변수를 사용하기 전에 미리 null 값과 비교하면 사전에 익셉션을 방지 할 수 있다.
			System.out.println("obj 변수가 가리키는 객체가 없습니다.");
			return;
		}
		System.out.println(obj.x);
		System.out.println(obj.y);
	}
}
