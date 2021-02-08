package Collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapEx01 {

	public static void main(String[] args) {
		
		String[] nation = {"한국", "일본", "중국", "미국", "태국", "영국"};
		String[] city = {"서울", "동경", "북경", "워싱턴", "방콕", "런던"};
		
		Map<String, String> list = new HashMap<String, String>();
		for(int i = 0; i < nation.length; i++) {
			list.put(nation[i], city[i]);
		}
		
		System.out.println(list.toString());
		System.out.println(">> 키값 : " + list.keySet());
		
		Collection<String> values = list.values();
		System.out.println(">> 값 : " + list.values());
		
		//값 추출
		Iterator<String> iter = list.keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String value = list.get(key);
			
			System.out.println("key : " + key + ", value : " + value);
		}
		
		System.out.println("--------");
		System.out.println(list.get("한국"));
	}

}
