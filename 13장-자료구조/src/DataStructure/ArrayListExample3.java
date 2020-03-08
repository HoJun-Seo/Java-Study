package DataStructure;

import java.util.ArrayList;
/*
 * ArrayList 에 있는 데이터를 검색하는 방법
 * ArrayList class 에 있는 indexOf method 는 데이터의 검색에 사용되는 메소드 이다.
 * 이 메소드는 검색할 데이터와 똑같은 값의 데이터를 파라미터로 넘겨주면 리스트에서 똑같은 값을 갖는 첫번째 데이터를 찾아서 그 위치의 인덱스를 리턴한다.
 * int index = list.indexOf("사과"); - 첫번째 "사과" 의 위치 1을 리턴한다.
 * 하지만 이 메소드는 파라미터와 같은 값의 데이터가 없으면 -1 을 리턴한다.
 * indexOf method 와는 반대로 리스트의 마지막부터 순서대로 데이터를 찾는 lastIndexOf method 도 있다.
 * int index = list.lastIndexOf("사과");
 */
public class ArrayListExample3 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("머루");
		list.add("사과");
		list.add("앵두");
		list.add("자두");
		list.add("사과");
		int index1 = list.indexOf("사과");
		int index2 = list.lastIndexOf("사과");
		System.out.println("첫번째 사과 : " + index1);
		System.out.println("마지막 사과 : " + index2);
	}
}
