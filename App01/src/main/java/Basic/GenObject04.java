package Basic;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class GenObject04 {

	public static void main(String[] args) {
		Student2<Integer, Integer> test1 = new Student2<Integer, Integer>(1,4);
		//Student2<Double, Double> test2 = new Student2<Double, Double>(1,4);
		// Integer 타입이 아니면 데이터를 넣을 수 없다.(extends Integer)
		test1.printInfo("서호준");
		
	}

}

@Getter
@AllArgsConstructor
class Student2<G extends Integer, C extends Integer>{
	G g;
	C c;
	
	public void printInfo(String name) {
		System.out.println(name + " 은 " + g + " 학년 " + c + " 반");
	}
}