package OOP;

public class SmartPhoneTest {
	public static void main(String[] args) {
		
		SmartPhone smartPhone = new SmartPhone("서호준", "010-1234-5678");
		smartPhone.call(smartPhone.phoneNumber);
	}
}

interface Phone{
	public void call(String targetNumber);
	
	public void ring();
}

class SmartPhone implements Phone{

	protected String name;
	protected String phoneNumber;
	
	public SmartPhone(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public void call(String targetNumber) {
		System.out.println(targetNumber + "로 전화를 겁니다.");
		ring();
		
	}

	@Override
	public void ring() {
		System.out.println("전화벨이 울립니다.");
		
	}
	
}
