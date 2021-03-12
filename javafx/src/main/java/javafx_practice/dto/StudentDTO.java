package javafx_practice.dto;

import javafx.beans.property.StringProperty;

public class StudentDTO {
	
	private StringProperty name;
	private StringProperty korean;
	private StringProperty english;
	private StringProperty math;
	private StringProperty social;
	private StringProperty science;
	
	public StudentDTO(StringProperty name, StringProperty korean, StringProperty english, StringProperty math, StringProperty social, StringProperty science) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.social = social;
		this.science = science;
	}
	
	public StringProperty nameProperty() {
		return name;
	}
	
	public StringProperty koreanProPerty() {
		return korean;
	}
	
	public StringProperty englishProperty() {
		return english;
	}
	
	public StringProperty mathProperty() {
		return math;
	}
	
	public StringProperty socialProperty() {
		return social;
	}
	
	public StringProperty scienceProperty() {
		return science;
	}

	public StringProperty getName() {
		return name;
	}
	public StringProperty getKorean() {
		return korean;
	}
	public StringProperty getEnglish() {
		return english;
	}
	public StringProperty getMath() {
		return math;
	}
	public StringProperty getSocial() {
		return social;
	}
	public StringProperty getScience() {
		return science;
	}
	
}
