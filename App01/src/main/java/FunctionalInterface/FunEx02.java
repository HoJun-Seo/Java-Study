package FunctionalInterface;

public class FunEx02 {
	public static void main(String[] args) {
		
		TestFunction tf01 = new TestFunction() {
			@Override
			public String apply(String str) {
				// TODO Auto-generated method stub
				return str.replace("-", "");
			}
		};
		
		String str = "010-0101-0100";
		System.out.println(str);
		System.out.println(tf01.apply(str));
		
		System.out.println("-- 람다식 --");
		TestFunction tf02 = (x) -> str.replace("-", "");
		System.out.println(tf02.apply(str));
	}
}

interface TestFunction{
	public abstract String apply(String str);
}
