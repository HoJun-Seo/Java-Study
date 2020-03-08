package Wrapper;
/*
 * 자바의 데이터 타입은 크게 프리미티브 타입과 레퍼런스 타입으로 나뉜다.
 * 수치, 문자, 논리값과 같은 간단한 데이터를 표현할 수 있는 것은 프리미티브 타입이고, 그 밖의 데이터 타입은 모두 레퍼런스 타입으로 분류된다.
 * 경우에 따라서는 프리미티브 타입의 값을 객체로 만들어야 할 필요가 있는데, 그렇게 하기 위해서는 프리미티브 타입을 표현하는 클래스가 필요하다.
 * 이 클래스들의 주 역할은 프리미티브 타입의 값을 담는 객체를 생성하는 것이다. 다시 말해서 이 클래스의 객체들은 프리미티브 타입의 값을 감싸는(wrap) 역할을 하기 때문에 
 * 이 클래스들을 통틀어 래퍼 클래스(Wrapper class) 라고 부른다.
 * 래퍼 클래스로 만든 객체를 래퍼 객체(Wrapper object) 라고 하는데, 하나의 래퍼 객체에는 하나의 프리미티브 값을 담을수 있으며, 그 값은 생성자 파라미터로 넘겨줘야 한다.
 * 파라미터로 넘겨진 프리미티브 값은 래퍼 객체 안에 저장된다. 
 * 래퍼 객체 안에 있는 값은 래퍼 클래스의 메소드를 이용하여 가져올수 있는데, 그 메소드의 이름은 해당 프리미티브 타입의 이름 뒤에 Value 를 붙인 이름이다.
 * 예를 들어 Integer 객체 안에 들어있는 int 타입의 값을 가져오는 메소드의 이름은 intValue 이다.
 * 하지만 래퍼 객체갚 생성되고 난 다음에 그 객체 안에 있는 프리미티브 타입의 값을 바꿀 수는 없다.
 */
public class WrapperExample1 {
	public static void main(String[] args) {
		//Integer 객체를 생성한다.
		Integer obj1 = new Integer(12);
		Integer obj2 = new Integer(7);
		//Integer 객체 안에 있는 int 값을 가져온다.
		int sum = obj1.intValue() + obj2.intValue();
		System.out.println(sum);
	}
}
/*
 * 래퍼 클래스에는 생성자를 대신하여 사용할 수 있는 valueOf method 가 있다.
 * 이 메소드에 래퍼 클래스의 생성자 파라미터에 해당하는 값을 넘겨주면, 그에 해당하는 래퍼 객체가 리턴된다.(Wrapper class 의 생성자를 대신하는 메소드)
 * Byte obj1 = Byte.valueOf((byte)1);
 * Short obj2 = Short.valueOf((short)123);
 * Integer obj3 = Integer.valueOf(12345);
 * Long obj4 = Long.valueOf(1234567890L);
 * Float obj5 = Float.valueOf(1.5f);
 * Double obj6 = Double.valueOf(1.00005);
 * Character obj7 = Character.valueOf('꽃');
 * Boolean obj8 = Boolean.valueOf(true);
 * 이 메소드의 기능은 겉으로는 생성자와 똑같으나, 이 메소드는 똑같은 파라미터 값을 두번 이상 넘겨주면 전에 만들어 두었던 래퍼 객체를 리턴하기 때문에 생성자와는 다르다.
 * 똑같은 프리미티브 값을 가지고 valueOf method 를 여러 번 호출하면 같은 객체에 대한 참조값이 리턴된다.
 * 그렇기 때문에 래퍼 객체를 많이 필요로 하는 프로그램에서 이 메소드를 사용하면 객체를 생성하는 시간과 객체가 차지하는 메모리를 절약할 수 있어 효율적이다.
 */
