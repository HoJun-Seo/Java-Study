package object_class;

public class Numbers {
	int num[];
	Numbers(int num[]) {
		this.num = num;
	}
	int getTotal() {
		int total = 0;
		for(int cnt = 0; cnt < num.length; cnt++) 
			total += num[cnt];
		return total;
	}
	int getAverage() {
		int total;
		total = getTotal(); //같은 클래스 내의 메소드 호출
		int average = total / num.length;
		return average;
	}
}
