package DataStructure;

import java.util.HashMap;
/*
 * 해쉬 테이블은(hash table) 여러개의 통에 번호를 붙여 놓고, 키 값을 이용하여 데이터가 들어갈 통 번호를 계산하는 자료구조 이다.
 * 데이터를 넣을 여러개의 통(bucket) 을 만들어두고, 키 값을 이용하여 데이터를 넣을 통 번호를 계산한다.
 * 데이터를 꺼낼때도 키 값을 이용하여 통 번호를 계산한 후, 그 통안에서 데이터를 찾는다. 이렇게 하면 통 안에서는 키 값을 일일이 비교해야 하지만
 * 전체 데이터의 키 값을 모두 비교하는 것보다는 훨씬 시간이 절약된다.
 * 해쉬 테이블을 만들기 위해서는 HashMap class 를 사용해야 하는데, 이 클래스에는 통을 만들고 , 통 번호를 계산하고, 통 안에서 키 값과 일치하는 데이터를 찾는 알고리즘이 모두 들어있다.
 * 해쉬 테이블을 만들때는 먼저 두 가지 데이터 타입을 정해야 한다. 하나는 해쉬 테이블에 저장할 데이터 타입이고, 다른 하나는 키(key) 타입이다.
 * 그 타입들을 이용하여 HashMap 객체를 생성해야 하는데, 객체를 생성할때는 <> 안에 두 개의 타입 파라미터를 써야 한다.
 * 앞에는 키의 타입을 쓰고, 뒤에는 데이터의 타입을 쓴다.
 * 객체가 생성되면 그 안에는 16개의 통이 생성되는데 이 수는 저장된 데이터의 수가 많아질수록 자동으로 늘어나지만, 처음부터 통을 많이 만들고 싶으면 생성자 파라미터로 통의 수를 넘겨주면 된다.
 * 예) HashMap<String, Integer> hashtable = new HashMap<String, Integer>(100); - 100개의 통으로 구성된 해쉬 테이블을 생성한다.
 * HashMap 에 데이터를 저장할 때는 put method 를 사용한다. 이 메소드에는 두 개의 파라미터를 넘겨주는데, 첫번째 파라미터는 키 값이여야 하고, 두번째 파라미터는 데이터여야 한다.
 * 두 파라미터 타입은 객체를 생성할떼 사용했던 타입 파라미터와 일치해야 한다.
 * put method 안에는 키 값을 이용하여 통 번호를 계산하는 로직이 포함되어 있다.
 * 예)hashtable.put("해리", new Integer(95)); - 해리 : 키 값, new Integer(95) : 데이터
 * 해쉬 테이블에 저장된 데이터는 get method 를 사용하여 읽어 올 수 있다
 * 예) Integer num = hashtable.get("해리"); - 해리 : 키 값, 키 값으로 통 번호를 계산하고, 그 통 안에서 키 값("해리") 과 일치하는 데이터를 찾아서 리턴한다.
 * get method 안에도 put method 처럼 키 값으로 통 번호를 계산하는 로직이 들어있다. 그것은 put method 에 있는 로직과 똑같다.
 * 그렇기 때문에 put method 를 호출했을 때와 같은 키 값을 가지고 get method 를 호출하면 데이터가 저장된 통 번호를 계산해 낼 수 있다.
 * 해쉬 테이블에 있는 데이터를 삭제 할 때는 remove method 를 사용한다. 이 메소드에도 키 값을 파라미터로 넘겨줘야 한다.
 * hashtable.remove("해리"); - 키 값으로 통 번호를 계산하고, 해당 통 에서 키 값과 일치하는 데이터를 찾아서 삭제한다.
 *  */
public class HashMapExample1 {
	public static void main(String[] args) {
		HashMap<String, Integer> hashtable = new HashMap<String, Integer>();
		//해쉬 데이블로 사용할 HashMap 객체를 생성한다.
		hashtable.put("해리", new Integer(95));
		hashtable.put("헤르미온느", new Integer(100));
		hashtable.put("론", new Integer(85));
		hashtable.put("드레이코", new Integer(93));
		hashtable.put("네빌", new Integer(70));
		//해쉬 데이블에 5개의 데이터를 추가한다.
		Integer num = hashtable.get("헤르미온느");
		System.out.println("헤르미온느의 성적은? " + num);
		//키 값으로 해쉬 테이블의 데이터를 찾아서 출력한다.
	}
}
