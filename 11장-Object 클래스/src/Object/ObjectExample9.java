package Object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/*
 * 생성된 객체 변수 에서 해당 변수에는 객체 자체가 아니라 객체의 참조값만 저장된다, 객체 자체는 메모리의 힙(heap) 영역에 저장된다.
 * 객체의 참조값은 바로 이 힙 안에 있는 객체의 위치를 찾는데 사용되는 정보이다.
 * 힙에 있는 객체는 그 객체를 가리키는 참조값을 통해서만 사용할 수 있으며, 변수에 저장된 참조값을 잃거나 변수 자체가 없어지면 그 객체는 더 이상 사용할 수 없는 상태가 된다.
 * 변수가 가지고 있던 참조값을 잃어버렸다고 해서 힙에 있는 객체가 바로 사라지는 것은 아니다. 객체를 가리키는 참조값이 없어도 그 객체는 당분간 힙에 남아있게 된다.
 * 그런 객체는 더 이상 사용될 수 없기 때문에 가비지(garbage : 쓰레기)라고 불리며, 힙에 이런 가비지가 많아져 다른 객체를 생성할 메모리가 부족해지면
 * JVM 안에 가비지 컬렉터(garbage collector)라는 모듈을 두고 그 모듈이 주기적으로 실행되어 힙에 있는 가비지를 자동으로 제거하도록 하고 있다.
 * 가비지 컬렉터는 힙이 가비지로 가득 차서 새로운 객체를 생성할 메모리가 부족하거나, 프로그램에서 특별히 다른 할 일이 없을 때 임의로 작동한다.
 * 즉, 프로그래머는 객체가 실제로 제거되는 정확한 시점을 알 수 없다.
 * 객체가 언제 제거되는 지는 알 수 없으나 객체가 제거될 때 수행시킬 로직은 finalize method로 구현이 가능하다. - 시스템 자원을 할당받는 프로그램에서 객체가 제거되지 전에 할당받은 시스템 자원을 해제해야 하는 경우
 * 가비지 컬렉터가 finalize method 를 자동으로 호출하는 예는 System class 를 다룰 때 참조할것
 */
public class ObjectExample9 {
	public static void main(String[] args) {
		Rectangle obj = new Rectangle(10, 20);
		Class cls = obj.getClass(); //obj 객체가 속해있는 Rectangle class 의 정보를 가져온다.
		String name = cls.getName(); //해당 클래스의 이름을 name 변수에 저장한다.
		System.out.println("클래스 이름 : " + name);
		Class superCls = cls.getSuperclass(); //해당 클래스의 슈퍼클래스의 정보를 superCls 변수에 저장한다.
		String superName = superCls.getName(); //슈퍼클래스의 이름을 superName 변수에 저장한다.
		System.out.println("슈퍼 클래스 이름 : " + superName);
		Field field[] = cls.getDeclaredFields(); //해당 클래스에 선언되어 있는 필드 정보를 가져온다. - 필드 배열로 리턴받음 
		System.out.println("필드 : ");
		for(int cnt = 0; cnt < field.length; cnt++)
			System.out.println("     " + field[cnt]); //배열의 처음부터 끝까지 출력한다.
		Method method[] = cls.getDeclaredMethods(); //해당 클래스에 선언되어 있는 메소드 정보를 가져온다. - 메소드 배열로 리턴받음
		System.out.println("메소드 : ");
		for(int cnt = 0; cnt < method.length; cnt++)
			System.out.println("    " + method[cnt]); //배열의 처음부터 끝까지 출력한다.
	}
}
/*
 * getClass method 는 객체가 속하는 클래스의 정보를 알아내는 메소드이다. getClass method 는 객체가 속하는 클래스의 정보를 Class 타입의 객체로 만들어서 리턴한다.
 * 그렇기 때문에 이 메소드가 리턴하는 값은 아래와 같이 Class 타입의 변수에 받아야 한다.
 * Class cls = obj.getClass(); - 객체가 속하는 클래스의 정보를 리턴
 * Class class 는 클래스에 대한 여러 가지 정보를 담는 기능을 하는데, 그런 정보는 get 이라는 이름으로 시작하는 메소드를 이용해서 가져올 수 있다.
 * 예를 들어 getName 과 getSuperclass method 를 호출하면 클래스의 이름과 슈퍼 클래스의 정보를 가져 올 수 있다.
 * String str = cls.getName(); - 클래스의 이름을 리턴하는 메소드
 * Class superCls = cls.getSuperclass(); - 슈퍼 클래스의 정보를 리턴하는 메소드
 * Class class 에는 필드와 메소드 정보를 가져오는 getDeclaredFields 와 getDeclaredMethods 라는 메소드도 있다. 
 * 이 메소드 들이 리턴하는 값은 각각 Field 배열과 Method 배열이므로 아래와 같은 방법으로 호출 할 수 있다.
 * Field field[] = cls.getDeclaredFields(); - 클래스에 선언되어 있는 필드 정보를 가져오는 메소드
 * Method method[] = cls.getDeclaredMethods(); - 클래스에 선언되어 있는 메소드 정보를 가져오는 메소드
 */

