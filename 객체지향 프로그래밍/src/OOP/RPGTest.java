package OOP;

public class RPGTest {
	public static void main(String[] args) {
		
		Novice novice = new Novice();
		novice.name = "프로도";
		novice.hp = 100;
		
		Wizard wizard = new Wizard();
		wizard.name = "해리포터";
		wizard.hp = 120;
		wizard.mp = 100;
		
		novice.punch();
		wizard.punch();
		
		wizard.fireball();
	}
}

class Novice{
	String name;
	int hp;
	
	public void punch() {
		System.out.println(this.name + "의 펀치!!");
	}
}


class Wizard extends Novice{
	int mp;
	
	public void fireball() {
		System.out.println(this.name + "의 파이어볼!!");
		
	}
}