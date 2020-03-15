package Serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//도서정보 클래스만 직렬화 가능 클래스로 만들경우
//Object class 가 아닌 다른 클래스를 상속받는다.
class BookInfo extends GoodsInfo implements java.io.Serializable{
	String writer; 
	int page;
	BookInfo(String name, String code, int price, String writer, int page) {
		super(name, code, price);
		this.writer = writer;
		this.page = page;
	}
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeUTF(code);
		out.writeUTF(name);
		out.writeInt(price);
		//슈퍼클래스의 필드를 직렬화 하는 명령문
		out.defaultWriteObject(); // 이 클래스의 필드를 한번에 직렬화 하는 메소드 호출문 - 22,23행 대신 사용할 수 있다.
		//out.writeUTF(writer);
		//out.writeInt(page);
		//해당 클래스의 필드를 직렬화 하는 명령문

	}
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		code = in.readUTF();
		name = in.readUTF();
		price = in.readInt();
		//슈퍼클래스의 필드를 역직렬화 하는 명령문
		in.defaultReadObject(); // 이 클래스의 필드를 한번에 역직렬화 하는 메소드 호출문 - 33,34행 대신 사용할 수 있다.
		//writer = in.readUTF();
		//page = in.readInt();
		//해당 클래스의 필드를 직렬화 하는 명령문
	}
}
