package Basic;

public class Genobj {
	// Object 타입은 모든 타입의 자료형을 전부 받을 수 있다.
	G01<Integer> test01 = new G01<Integer>();
	G01<Double> test02 = new G01<Double>();
	G01<String> test03 = new G01<String>();

}


class G01<T>{
	private T a;

	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}
	
}
