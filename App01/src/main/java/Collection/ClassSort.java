package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ClassSort {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(3, "홍길동"));
		list.add(new Employee(8, "동순이"));
		list.add(new Employee(1, "동길이"));
		list.add(new Employee(2, "동순이"));
		
		System.out.println(list.toString());
		Collections.sort(list);
		System.out.println(list.toString());
	}

}


@Data // getter, setter, toString, equals.....
@AllArgsConstructor
class Employee implements Comparable<Employee>{
	private int sabun;
	private String name;
	
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		// return this.sabun - o.sabun;
		// 오름차순 : return this.sabun - 매개변수.sabun
		// 내림차순 : return 매개변수.sabun - this.sabun
		
		// 정렬항목이 String 일 경우 compareTo() 메소드를 사용한다.
		return this.name.compareTo(o.name); // String 오름차순
		// return o.name.compareTo(this.name); String 내림차순
	}
}

//class 객체가 배열, class 멤버변수들 중에서 어떤 자료를 기준으로 정렬할 경우
// Comparable 인터페이스를 받아 comepareTo() 메소드를 구현하여 정렬한다.
