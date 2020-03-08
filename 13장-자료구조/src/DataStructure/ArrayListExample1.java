package DataStructure;

import java.util.ArrayList;
/*
 * 자바 프로그래머는 자료구조의 알고리즘을 직접 구현할 필요가 없다. 이미 jdk 라이브러리에 알고리즘을 구현해 놓은 자료구조 클래스들이 있기 때문이다.
 * 자료구조 클래스는 이름 뒤쪽에 <E> 또는 <K, V> 라고 표시되는데 이 부분은 자료구조에 저장할 데이터의 타입을 써넣는 부분이다.
 * 예를 들어 ArrayList class 를 이용해 문자열을 저장할 리스트를 만들고 싶다면 ArrayList<String> 이라는 이름으로 사용한다.
 * 예) ArrayList<String> list = new ArrayList<String>(); - String 객체를 담을 수 있는 ArrayList 객체를 생성한다.
 * <> 안에 쓰여진 타입을 타입 파라미터 라고 하며 자료구조에 저장할 수 있는 데이터의 타입을 제한하는 역할을 한다.
 * 타입 파라미터에 저장할 타입은 래퍼런스 타입의 데이터만 가능하다.(프리미티브 타입은 불가능)
 * ArrayList class 는 객체 내부에 있는 배열에 데이터를 저장하는 방식이다.
 * ArrayList 객체를 생성하면 객체 안에는 10개의 문자열을 저장할 수 있는 배열이 생성되는데 이 크기는 리스트에 저장된 데이터의 수가 늘어나면 자동으로 증가하지만
 * 처음부터 배열의 크기를 크게 잡고 싶으면 배열의 크기를 생성자 파라미터로 넘겨주면된다. - new ArrayList<String>(50);
 * ArrayList 객체에는 add method 를 사용하여 데이터를 추가 할 수 있다. 이 메소드는 리스트의 마지막에 데이터를 추가하기 때문에
 * 연속적으로 호출하면 호출된 순서대로 데이터가 저장된다. - list.add("포도"); - 타입 파라미터와 맞는 데이터 값을 넘겨줘야 한다.
 * 리스트에 있는 데이터는 get method 를 통해 가져올 수 있다. 이때 파라미터로는 데이터의 인덱스를 넘겨줘야 한다.
 * String str = list.get(2); - 인덱스 2 위치에 있는 데이터를 리턴한다.
 * 그런데 get method 는 데이터의 존재 범위를 넘어선 인덱스를 넘겨주면 IndexOutOfBoundsException 을 발생한다.
 * 이런 익셉션이 발생하지 않도록 하기 위해서는 리스트에 있는 데이터의 수를 미리 알아내야 하는데, 그런 일은 size method 를 호출해서 할 수 있다.
 * int num = list.size(); - 리스트에 있는 데이터의 수를 리턴한다.
 */
public class ArrayListExample1 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		int num = list.size();
		for(int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}
	}
}
