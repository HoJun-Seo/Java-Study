package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapObj01 {

	public static void main(String[] args) {
		
		var map = new HashMap<String, Integer>();
		//Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("Java", 1);
		map.put("C", 2);
		map.put("C++", 3);
		map.put("Python", 4);
		map.put("JavaScript", 5);
		map.put("Jquery", 6);
		map.put("DB", 7);
		
		Map beforeMap = (Map) map.clone(); // 타입 캐스트를 이용한 복사
		//Map<String, Integer> beforeMap = new HashMap<String, Integer>(map); -> 생성자를 이용한 복사
		Set<String> keys = map.keySet();
		
		for(String key : keys) {
			System.out.println(key);
		}
		
		// 람다식
		System.out.println("--람다식");
		keys.forEach((s)->System.out.println(s));
		
		// 메소드 참조
		System.out.println("--메소드 참조");
		keys.forEach(System.out::println);
		
		System.out.println(map.toString());
		if(map.containsKey("DB")){
			map.remove("DB");
		}else {
			System.out.println("DB 가 없습니다.");
		}
		System.out.println(map.toString());
		
		map.put("Ruby", 10);
		
		map.computeIfPresent("C", (String key, Integer value)-> ++value);
		System.out.println(map.toString());
	}
}

// Map 인터페이스를 받아 구현하는 HashMap, Hashtable, TreeMap
// Key, Value(키,값) 으로 구성하여 저장
