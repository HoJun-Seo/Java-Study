package Exception;

public class AutoMachineStart {

	public static void main(String[] args) {
		// try 문에서 매개변수로 객체를 생성해 줄 수 있다.
		try (AutoMachine machine = AutoMachine.getInstance()){
			machine.run();
			// 굳이 객체를 해제하는 코드를 작성하지 않아도 된다.
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
