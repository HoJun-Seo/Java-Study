package javafx_practice.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx_practice.dto.StudentDTO;

public class StudentAddController implements Initializable{
	@FXML TextField input_name;
	@FXML TextField input_korean;
	@FXML TextField input_english;
	@FXML TextField input_math;
	@FXML TextField input_social;
	@FXML TextField input_science;
	@FXML Button btnConfirm;
	ObservableList<StudentDTO> student_list;

	public ObservableList<StudentDTO> getStudent_list() {
		return student_list;
	}

	public void setStudent_list(ObservableList<StudentDTO> student_list) {
		this.student_list = student_list;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnConfirm.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				if(input_name.getText().isEmpty() || input_korean.getText().isEmpty() 
						|| input_english.getText().isEmpty() || input_math.getText().isEmpty()
						|| input_social.getText().isEmpty() || input_science.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warninig Dialog");
					alert.setHeaderText("Input Data is Empty");
					alert.setContentText("Please input data on all textfield");
					
					alert.showAndWait();
				}
				else {
					student_list.add(
							new StudentDTO(new SimpleStringProperty(input_name.getText()),
									new SimpleStringProperty(input_korean.getText()),
									new SimpleStringProperty(input_english.getText()),
									new SimpleStringProperty(input_math.getText()),
									new SimpleStringProperty(input_social.getText()),
									new SimpleStringProperty(input_science.getText())
							)
					);
					
					exit();
				}
			}

			public void exit() {
				Stage stage = (Stage) btnConfirm.getScene().getWindow();
				stage.close();
			}
		});
	}
}
