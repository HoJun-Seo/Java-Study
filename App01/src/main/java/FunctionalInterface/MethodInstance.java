package FunctionalInterface;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodInstance {

	public static void main(String[] args) {
		String greeting = "Hello";
		System.out.println("--- toString() ---");
		System.out.println(greeting.toString());
		System.out.println("-------");
		// Consumer 함수형 인터페이스 : 매개변수1, 리턴값 없음
		// 함수형 인터페이스 함수형변수 = 함수식;
		Consumer<String> consumer = System.out::println;
		consumer.accept(greeting);
		
		// 생성된 인스턴스의 메소드를 참조
		System.out.println("-- 인스턴스의 메소드 참조 방식 --");
		writeString(greeting::toString);
	}

	public static void writeString(Supplier<String> supplier) {
		System.out.println(supplier.get());
	}

}
