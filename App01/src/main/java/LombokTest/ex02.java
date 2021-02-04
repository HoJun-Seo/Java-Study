package LombokTest;

import java.util.Arrays;

import lombok.Builder;
import lombok.ToString;

public class ex02 {

	public static void main(String[] args) {
		Member[] members = new Member[3];
		
		members[0] = Member.builder()
				.name("서호준")
				.age(26)
				.build();
		members[1] = Member.builder()
				.age(26)
				.build();
		System.out.println(Arrays.deepToString(members));
	}

}

@ToString
class Member{
	String name;
	int age;
	
	@Builder
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	
}
