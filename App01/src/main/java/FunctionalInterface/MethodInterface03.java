package FunctionalInterface;

import lombok.Getter;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Setter;

public class MethodInterface03 {

	public static void main(String[] args) {
		var list = Arrays.asList(
				new Person(1, "홍길동"),
				new Person(2, "홍길동"),
				new Person(3, "홍길동"),
				new Person(4, "홍길동"));
		System.out.println("-- 람다식 --");
		list.forEach(x -> x.toObjString());
		
		System.out.println("-- 메소드 참조 --");
		list.forEach(Person::toObjString);
		
		System.out.println("-- for --");
		for(Person p : list) {
			p.toObjString();
		}
	}
	

}

@Getter
@Setter
@AllArgsConstructor
class Person{
	private Integer no;
	private String name;
	
	public void toObjString() {
		System.out.println("Person [no=" + no + ", name=" + name + "]");
	}
}
