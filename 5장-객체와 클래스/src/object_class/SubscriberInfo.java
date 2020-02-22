package object_class;
//두 개의 생성자를 가지는 클래스 - 가입자 정보 클래스
public class SubscriberInfo {
	String name, id, password;
	String phoneNo, address;
	SubscriberInfo() {}
	/*
	 * no-arg-constructor(파라미터 변수가 없는 생성자)를 추가하여 
	 * 파라미터 변수를 넘겨주지 않는 객체 생성식이 작성되었을때 발생할 에러를 방지한다.
	 * 파라미터 변수를 넘겨주지 않는 객체 생성식이 작성되었을 경우, 파라미터 값의 대입을 따로 해주는 방식으로 코드를 작성한다.
	 * 선언된 생성자가 하나도 없는 클래스를 컴파일 할 경우, 자바 컴파일러는 자동으로 no-arg-constructor 를 만들어서 추가한다.(디폴트 생성자)
	 * 그러나 클래스에 선언된 생성자가 하나라도 있을 경우, 자바 컴파일러는 디폴트 생성자를 추가하지 않는다.
	 */
	SubscriberInfo(String name, String id, String password) {
		this.name = name;
		this.id = id;
		this.password = password;
	}//3개의 String type 파라미터를 받는 생성자 선언 
	//파라미터 변수와 필드의 이름이 같을때는 이름 앞에 this. 를 붙여서 구분한다.
	SubscriberInfo(String name, String id, String password, String phoneNo, String address) {
		this(name, id, password); //생성자 안에서 생성자를 다시 호출하여 코드 작성의 편의성을 확보한다.-> 14행에 선언되어 있는 생성자 호출
		//주의 - 생성자 안에서 생성자를 호출할 때는 반드시 해당 생성자의 첫번째 명령문으로 작성해야 한다.
		this.phoneNo = phoneNo;
		this.address = address;
	}//5개의 String type 파라미터를 받는 생성자 선언
	/*
	 * 두 개의 생성자가 있어도 객체 생성식에 있는 파라미터의 수, 타입, 순서로 어느 생성자인지 구분되기 때문에
	 * 두 생성자를 모두 사용할 수 있다.
	 * 파라미터 변수의 이름은 생성자 구분의 기준이 되지 않기 때문에, 파라미터의 수가 같을 때 변수의 이름을 다르게 생성하는 것은 잘못된 구분이 될 수 있다.
	 */
	void changePassword(String password) {//메소드 호출 - 전화번호 교체
		this.password = password;
	}
	void setPhoneNo(String phoneNo) { //메소드 호출 - 전화번호 설정
		this.phoneNo = phoneNo;
	}
	void setAddress(String address) { //메소드 호출 - 주소 설정
		this.address = address; //파라미터 변수와 필드의 이름이 같을때는 이름 앞에 this. 를 붙여서 구분한다.
	}
}
