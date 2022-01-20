package OOP;

import java.util.ArrayList;
import java.util.List;

public class ElvesTest {
	public static void main(String[] args) {
		
		// 업캐스팅 사용
		Elf elf = new Elf("티란데", 100);
		Elf highElf = new HighElf("말퓨리온", 160, 100);
		Elf elfLord = new ElfLord("마이에브", 230, 140, 100);
		
//		Elf[] elves = {elf, highElf, elfLord};
		
		List<Elf> elfList = new ArrayList<Elf>();
		elfList.add(elf);
		elfList.add(highElf);
		elfList.add(elfLord);
		
		for(int i = 0; i < elfList.size(); i++) {
//			System.out.println(elves[i].toString());
			System.out.println(elfList.get(i).toString());
		}
	}
}

class Elf{
	protected String name;
	protected int hp;
	
	public Elf(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}
	
	@Override
	public String toString() {
		
		return "[엘프] Name : " + this.name + ", HP : " + this.hp;
	}
}

class HighElf extends Elf{

	protected int mp;
	
	public HighElf(String name, int hp, int mp) {
		super(name, hp);
		this.mp = mp;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[하이엘프] Name : " + this.name + ", HP : " + this.hp + ", MP : " + this.mp;
	}
}

class ElfLord extends HighElf{

	protected int shield;
	
	public ElfLord(String name, int hp, int mp, int shield) {
		super(name, hp, mp);
		this.shield = shield;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[하이엘프] Name : " + this.name + ", HP : " + this.hp + ", MP : " + this.mp + ", SH : " + this.shield;
	}
}
