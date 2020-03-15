package Serialization;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*
 * 직렬화 메소드와 역직렬화 메소드 - 희소 배열의 경우(2차원 배열에서 대부분의 항목들이 0 이라는 무의미한 값들로 채워져 있는 배열)
 * 희소 배열의 경우 디폴트 직렬화 매커니즘으로 직렬화를 하면 의미 없는 데이터가 많은 공간을 차지하게 되어 메모리와 전송 시간의 낭비를 초래하게 된다.
 * 그렇기 때문에 이런 배열을 직렬화할 때는 의미 있는 데이터만 골라서 스트림으로 만드는 것이 효율적이다.
 * 이렇게 원하는 데이터만 선별적으로 직렬화 하기 위해서는 프로그래머가 그런 일을 하는 명령문을 직접 작성해야 한다.
 * 그리고 직렬화된 스트림을 다시 객체로 만들기 위해서도 그에 맞는 역직렬화 명령문을 직접 작성해야 한다.
 * 직접 작성한 직렬화/역직렬화 매커니즘으로 만들어진 파일과 디폴트 매커니즘으로 만들어진 파일의 크기를 비교해보면 둘의 차이를 알 수 있다.
 * 디폴트 매커니즘 - writeObject method, readObject method 주석처리시 구현 가능 
 */
public class DistrChart implements Serializable{
	int arr[][];
	DistrChart(){
		arr = new int[10][10];
	}
	//직렬화 메소드 작성
	/*
	 * writeObject 라는 이름으로 선언해야 하며, 형식은 아래를 따른다. - private 키워드, ObjectOutputStream 타입의 파라미터를 받는 void 타입,IOException 을 메소드 밖으로 던지는 throws 절
	 * 필드 값을 직렬화 하는 명령문은 ObjectOutputStream 파라미터에 대해 write- method 를 호출하는 명령문으로 만들어야 한다.  
	 */
	private void writeObject(ObjectOutputStream out) throws IOException{
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[0].length; col++) {
				if(arr[row][col] != 0) {
					out.writeInt(row);
					out.writeInt(col);
					out.writeInt(arr[row][col]);
					/*
					 * arr 배열에서 0 이 아닌 항목들의 값만 행 번호, 열 번호와 함께 writeInt method 를 통해 출력한다.
					 * 다른 타입의 데이터를 출력하고 싶다면 ObjectOutputStream class 에 있는 다른 write- method(writeChar, writeDouble 등)를 이용하면 된다.
					 * 직렬화 메소드 안에서 호출하는 write method 가 발생하는 IOException 을 try - catch 문으로 처리하는 것이 아니라, 그대로 메소드 밖으로 던져야 한다.
					 */
				}
			}
		}
	}
	//역 직렬화 메소드 작성
	/*
	 * readObject 라는 이름으로 선언해야 하며, 형식은 아래를 따른다. - private 키워드, ObjectInputStream 타입의 파라미터를 받는 void 타입, IOException 과 ClassNotFoundException 을 메소드 밖으로 던지는 throws 절
	 * 역직렬화를 수행하는 명령문은 ObjectInputStream 파라미터에 대해 read- method 를 호출하는 명령문으로 만들어야 한다.
	 * 주의 할점은 역직렬화 메소드 안에서 read- method 를 호출하는 순서는 직렬화 메소드 안에서 write- method 를 호출하는 순서와 같아야 한다.
	 */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		arr = new int[10][10];
		try {
			while(true) {
				int row = in.readInt();
				int col = in.readInt();
				int data = in.readInt();
				arr[row][col] = data;
			}
		}
		catch(EOFException e) {
		}
	}
}
