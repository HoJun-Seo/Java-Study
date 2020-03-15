package Serialization;
/*
 * 직렬화 대상이 되는 클래스의 구성요소
 * 직렬화, 다시 말해 객체를 스트림으로 만든다는 것은 그 객체가 가지고 있는 구성요소를 스트림으로 만드는 것을 의미한다.
 * 객체를 직렬화 할때 그 객체가 가지고 있는 필드, 메소드, 생성자는 모두 스트림으로 만들어지는 것이 아니라, 오직 객체가 가지고 있는 필드 만이 스트림으로 만들어진다.
 * 프리미티브 타입과 직렬화 가능 클래스 타입의 필드는 모두 직렬화가 가능하다, 하지만 그 밖의 타입은 모두 직렬화가 불가능하다.
 */
public class BBSItem implements java.io.Serializable{
	static int itemNum = 0; //정적 필드는 직렬화 대상이 되지 않는다. - 게시물의 수
	String writer; //글쓴이
	transient String passwd; //passwd 필드는 직렬화 대상에서 제외시킨다. - 패스워드
	String title; //제목
	String content; //내용
	Object attachment; //첨부파일 - static 키워드와 transient 키워드가 붙지 않았음에도  Object 타입이기 때문에 직렬화가 불가능하다.
	//static 키워드 가 붙은 정적 필드는 직렬화 대상이 되지 않으나, 그렇지 않은 필드들은 직렬화 대상이 될 수 있다.
	//만약 인스턴스 필드 중에 스트림으로 만들고 싶지 않은 필드가 있을 때는, 해당 필드의 선언문 앞에 transient 키워드를 붙이면 된다.
	//이 단어는 "일시적인" 이라는 뜻으로 자바에서는 직렬화에서 제외시킬 필드를 표시하는 키워드로 사용된다.
	//Object 타입의 필드는 java.io.Serializable interface 를 구현하지 않기 때문에 직렬화 가능 클래스가 아니다.
	BBSItem(String writer, String passwd, String title, String content){
		this.writer = writer;
		this.passwd = passwd;
		this.title = title;
		this.content = content;
		itemNum++;
	}
	//생성자는 직렬화 대상이 되지 않는다.
	void modifyContent(String content, String passwd) {
		if(!passwd.equals(this.passwd))
			return;
		this.content = content;
	}
	//메소드는 직렬화 대상이 되지 않는다.
	void addAttachment(Object attachment) {
		this.attachment = attachment;
	}
	//파일을 첨부한다.
}
