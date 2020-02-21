package object_class;

public class ObjectExample1 {
	public static void main(String[] args) {
		StringBuffer obj; //객체 변수 선언
		obj = new StringBuffer("Hey, Java"); //객체 생성(StringBuffet class)
		obj.deleteCharAt(1); //메소드 호출(StringBuffer class 에 정의되어 있는 method)
		obj.deleteCharAt(1);
		obj.insert(1, 'i');
		System.out.println(obj);
	}
}
