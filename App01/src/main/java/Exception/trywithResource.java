package Exception;

public class trywithResource {
	public static void main(String[] args) {
		
		AutoMachine machine = AutoMachine.getInstance();
		try {
			machine.run();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(machine != null) {
				try {
					machine.close();
				}catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}
	}
}

class AutoMachine implements AutoCloseable{
	
	private static AutoMachine machine;
	
	public static AutoMachine getInstance() {
		System.out.println("AutoMachine 을 시작합니다.");
		// machine 객체를 할당받음
		machine = new AutoMachine(); // 실제 객체 생성
		
		return machine;
	}
	public void run() throws Exception{
		System.out.println("AutoMachine 이 동작합니다.");
		System.out.println(1000/0); // 강제로 익셉션을 발생시켜보자.
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("AutoMachine 을 종료합니다.");
		// machine 객체를 비우는 역할
		machine = null; // machine 이 종료되었으므로 null 값으로 변경해준다.
	}
	
}

/*
 * AutoCloseable 인터페이스
 * 
 */
