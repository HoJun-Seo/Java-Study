package OOP;

public class Polymorphism {
	public static void main(String[] args) {
		HolyKnight holyKnight = new HolyKnight("홀리나이트", 180);
		
		Tanker tanker = holyKnight; // 인터페이스로 업캐스팅 가능
		tanker.increaseHp();
		
		Healer healer = holyKnight;
		healer.heal();
		
		// Holyknight 클래스로 정의된 객체가, 인터페이스인 Tanker, Healer 객체로 업캐스팅이 가능한 것을 확인할 수 있다.
		// 이와 같이 한 클래스가 구현하고 있는 여러 인터페이스로 객체를 정의할 수 있는 특징을 객체의 다형성 이라고 한다.
	}
}

interface Tanker{
	public void increaseHp();
}

interface Healer{
	public void heal();
}

class HolyKnight implements Tanker, Healer{
	private String name;
	private int hp;
	
	public HolyKnight(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	@Override
	public void heal() {
		System.out.println("체력을 +30 회복합니다.");
		
	}

	@Override
	public void increaseHp() {
		System.out.println("전체 체력을 +50 증가시킵니다.");
		this.hp += 50;
	}
}
