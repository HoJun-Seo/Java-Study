package OOP;

public class VariousRoles {
	public static void main(String[] args) {
		
		Person person = new Person("서호준");
		
		Developer developer = person;
		developer.programming("JAVA");
		
		Instructor instructor = person;
		instructor.teach("알고리즘");
		
		Masseur masseur = person;
		masseur.massage();
	}
}

interface Developer{
	public void programming(String lang);
}

interface Instructor{
	public void teach(String subject);
}

interface Masseur{
	public void massage();
}

class Person implements Developer, Instructor, Masseur{
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public void massage() {
		System.out.println(this.name + " -> 마사지 중!");
		
	}

	@Override
	public void teach(String subject) {
		System.out.println(this.name + " -> " + subject + " 수업 중!");
		
	}

	@Override
	public void programming(String lang) {
		System.out.println(this.name + " -> " + lang + " 프로그래밍 중!");
		
	}
}
