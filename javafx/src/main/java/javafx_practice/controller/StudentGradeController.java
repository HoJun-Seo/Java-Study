package javafx_practice.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx_practice.dto.StudentDTO;

public class StudentGradeController implements Initializable{
	
	ObservableList<StudentDTO> student_list;
	
	public ObservableList<StudentDTO> getStudent_list() {
		return student_list;
	}
	public void setStudent_list(ObservableList<StudentDTO> student_list) {
		this.student_list = student_list;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
