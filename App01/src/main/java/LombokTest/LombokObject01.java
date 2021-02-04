package LombokTest;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class LombokObject01 {
	
	@NonNull
	private String name;
	private String email;
	private int age;
	private String tel;
	
	@Builder // 멤버변수 전체에 대한 생성자에 @Builder 어노테이션 적용
	public LombokObject01(@NonNull String name, String email, int age, String tel) {
		if(name == null) {
			throw new NullPointerException();
		}else {
			this.name = name;
			this.email = email;
			this.age = age;
			this.tel = tel;
		}

	}
	
	
}
