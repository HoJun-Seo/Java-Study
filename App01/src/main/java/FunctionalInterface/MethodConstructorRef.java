package FunctionalInterface;

import java.util.function.Supplier;

import lombok.Getter;

public class MethodConstructorRef {

	public static void main(String[] args) {
		// Supplier 함수형 인터페이스 : return 값 없음
		Supplier<Name> supplier = () -> new Name();
		Name name1 = supplier.get();
		System.out.println("람다식 : " + name1.getName());
		
		Supplier<Name> supplier2 = Name::new;
		Name name2 = supplier2.get();
		System.out.println("생성자 참조 : " + name2.getName());
		
		System.out.println("-- 일반적인 방식 --");
	}
	
	
}

@Getter
class Name {
	private String name;
	
	public Name() {
		this.name = "서호준";
	}
}
