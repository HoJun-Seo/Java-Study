package Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MapEx02 {

	public static void main(String[] args) {
		Map<String, Object> mapList = new HashMap<String, Object>();
		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student("2021001", "길순이", 1));
		list.add(new Student("2020002", "동길이", 2));
		list.add(new Student("2018003", "길동이", 3));
		list.add(new Student("2021004", "동순이", 4));
		
		System.out.println(list);
		mapList.put("list", list); //key, value
		List<Student> list2 = (List<Student>)mapList.get("list");
		for(Student st : list2) {
			System.out.println(st);
		}
		
	}

}

// 학생정보 구조
@Data
@AllArgsConstructor
class Student {
	private String no;
	private String name;
	private int year;
}
