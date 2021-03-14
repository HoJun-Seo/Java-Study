package javafx_practice.dto;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StudentGrade extends StudentDTO implements Comparable<StudentGrade>{
	
	private StringProperty name;
	private DoubleProperty average;
	private IntegerProperty order;
	private StringProperty grade;
	
	private DoubleProperty korean = new SimpleDoubleProperty();
	private DoubleProperty english = new SimpleDoubleProperty();
	private DoubleProperty math = new SimpleDoubleProperty();
	private DoubleProperty social = new SimpleDoubleProperty();
	private DoubleProperty science = new SimpleDoubleProperty();
		
	public StringProperty getName() {
		return name;
	}
	public void setName(StringProperty name) {
		this.name = name;
	}
	public DoubleProperty getAverage() {
		return average;
	}
	
	public void setAverage(StudentDTO st) {
		korean.setValue(Double.parseDouble(st.getKorean().getValue()));
		english.setValue(Double.parseDouble(st.getEnglish().getValue()));
		math.setValue(Double.parseDouble(st.getMath().getValue()));
		social.setValue(Double.parseDouble(st.getSocial().getValue()));
		science.setValue(Double.parseDouble(st.getScience().getValue()));
		
		Double temp = (korean.getValue() + english.getValue() +
						math.getValue() + social.getValue() +
						science.getValue()) / 5;
				
		this.average = new SimpleDoubleProperty();
		this.average.setValue(temp);
	}
	
	public IntegerProperty getOrder() {
		return order;
	}
	public void setOrder(IntegerProperty order) {
		this.order = order;
	}
	public StringProperty getGrade() {
		return grade;
	}
	public void setGrade(StringProperty grade) {
		this.grade = grade;
	}
	@Override
	public int compareTo(StudentGrade o) {
		return (int) (o.getAverage().getValue() - getAverage().getValue());
	}
	
	
}
