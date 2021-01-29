package chap01;

public class op02 {
	public static void main(String[] args) {
		int a, b, add, sub, mul, div2;
		float div1;
		
		a = 10; b = 3;
		add = a + b;
		sub = a - b;
		mul = a * b;
		div1 = (float)a / b;
		div2 = a % b;
		
		System.out.printf("%d + %d = %d\n", a,b,add);
		System.out.printf("%d - %d = %d\n", a,b,sub);
		System.out.printf("%d * %d = %d\n", a,b,mul);
		System.out.printf("%d / %d = %f\n", a,b,div1);
		System.out.printf("%d %% %d = %d\n", a,b,div2);
	}
}
