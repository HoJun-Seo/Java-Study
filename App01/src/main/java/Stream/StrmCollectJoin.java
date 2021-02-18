package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StrmCollectJoin {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("py","java","c");
		
		list.forEach(System.out::println);
		
		// 단순 조합
		String a = list.stream().collect(Collectors.joining());
		System.out.println("단순 조합 : " + a);
		
		// 요소와 요소를 구분자로 구분
		String b = list.stream().collect(Collectors.joining(","));
		System.out.println("구분자 포함해서 조합 : " + b);
		
		// 구분자, 접두사, 접미사
		String c = list.stream().collect(Collectors.joining(", ", "프로그래밍 언어는", "등이 있습니다."));
		System.out.println("구분사, 접두사, 접미사 조랍 : " + c);
	}

}
