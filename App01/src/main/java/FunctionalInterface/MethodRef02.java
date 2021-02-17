package FunctionalInterface;

import java.util.function.Function;

public class MethodRef02 {

	public static void main(String[] args) {
		Function<String, String> helloLambda = (name) -> HelloTo.hello(name);
		System.out.println(helloLambda.apply("홍길동"));
		
		Function<String, String> helloStatic = HelloTo::hello;
		System.out.println(helloStatic.apply("홍길순"));
	}

}

class HelloTo{
	public static String hello(String name) {
		return "Hello!!" +name;
	}
}
