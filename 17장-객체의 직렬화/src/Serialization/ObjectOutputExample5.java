package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/*
 * DistrChart 객체를 직렬화 하는 프로그램
 */
public class ObjectOutputExample5 {
	public static void main(String[] args) {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("output5.dat"));
			DistrChart obj = new DistrChart();
			obj.arr[0][1] = 2;
			obj.arr[4][5] = 5;
			obj.arr[6][1] = 2;
			obj.arr[7][7] = 7;
			obj.arr[8][4] = 21;
			out.writeObject(obj);
		}
		catch(IOException ioe) {
			System.out.println("파일로 출력할 수 없습니다.");
		}
		finally {
			try {
				out.close();
			}
			catch(Exception e) {
			}
		}
	}
}
