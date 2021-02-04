package LombokTest;

import lombok.Data;

@Data
public class LombokClass01 {

	public static void main(String[] args) {
		LombokObject01 lo = new LombokObject01();
		LombokObject01 lo02 = LombokObject01.builder()
				.name("서호준")
				.email("ghwns6659@gmail.com")
				.build();
		
		lo.setName("서호준");
		System.out.println(lo.getName());
		System.out.println(lo02.getName());
		System.out.println(lo02.getEmail());
	}

}
