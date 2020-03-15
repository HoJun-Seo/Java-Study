package Serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
 * 직렬화 가능 클래스의 writeObject method 와 readObject method 를 호출하는 명령문은 ObjectOutput, InputStream5 프로그램에 존재하지 않았지만
 * 결과를 확인해보면 두 메소드가 호출되어서 실행됨을 볼 수 있다.
 * 이는 ObjectOutputStream class 의 writeObject method 를 호출하면, 그 메소드 안에서 직렬화 가능 클래스(DistrChart)의 writeObject method 가 간접적으로 호출되고
 * ObjectInputStream class 의 readObject method 를 호출하면, 그 메소드 안에서 직렬화 가능 클래스의 readObject method 가 간접적으로 호출되기 때문이다.
 * 그렇기 때문에 직렬화 가능 클래스의 writeObject method 안에서 발생한 IOException 을 메소드 밖으로 던지면 그 익셉션은 ObjectOutputStream class 의 writeObject method를 거쳐서
 * 그 메소드를 호출 한 쪽으로 전달된다.
 * 직렬화 가능 클래스의 readObject method 안에서 발생한 IOException, ClassNotFoundException 의 경우에도 마찬가지이다.
 */
public class ObjectInputExample5 {
	public static void main(String[] args) {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream("output5.dat"));
			DistrChart obj = (DistrChart)in.readObject();
			for(int row = 0; row < obj.arr.length; row++) {
				for(int col = 0; col < obj.arr[0].length; col++) {
					System.out.printf("%3d", obj.arr[row][col]);
				}
				System.out.println();
			}
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}
		catch(EOFException eofe) {
			System.out.println("끝");
		}
		catch(IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
		catch(ClassNotFoundException cnfe) {
			System.out.println("해당 클래스가 존재하지 않습니다.");
		}
		finally {
			try {
				in.close();
			}
			catch(Exception e) {
			}
		}
	}
}
