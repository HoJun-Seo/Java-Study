package Exception;
//직접 만든 InvaildInpuyExceptin class 를 사용하는 클래스
public class ExceptionExample11 {
	public static void main(String[] args) {
		try {
			int result = subtract(5, 100);
			System.out.println(result);
		}
		catch(InvaildInputException e) {
			System.err.println(e.getMessage());
		}
	}
	static int subtract(int a, int b) throws InvaildInputException {
		if(a < b)
			throw new InvaildInputException();
		return a - b;
	}
}
