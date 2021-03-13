package javafx_practice.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx_practice.dto.StudentDTO;

public class StudentGradeController implements Initializable{
	@FXML private TableView<StudentDTO> gradeTable;
	@FXML private TableColumn<StudentDTO, String> name;
	@FXML private TableColumn<StudentDTO, String> average;
	@FXML private TableColumn<StudentDTO, String> order;
	@FXML private TableColumn<StudentDTO, String> grade;
	@FXML private Button btnOK;
	
	ObservableList<StudentDTO> student_list;
	
	public ObservableList<StudentDTO> getStudent_list() {
		return student_list;
	}
	public void setStudent_list(ObservableList<StudentDTO> student_list) {
		this.student_list = student_list;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
