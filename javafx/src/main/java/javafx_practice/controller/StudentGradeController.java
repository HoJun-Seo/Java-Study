package javafx_practice.controller;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx_practice.dto.StudentDTO;
import javafx_practice.dto.StudentGrade;

public class StudentGradeController implements Initializable{
	@FXML private TableView<StudentGrade> gradeTable;
	@FXML private TableColumn<StudentGrade, String> name;
	@FXML private TableColumn<StudentGrade, Double> average;
	@FXML private TableColumn<StudentGrade, Integer> order;
	@FXML private TableColumn<StudentGrade, String> grade;
	@FXML private Button btnPrint; 
	@FXML private Button btnOK;
	
	ObservableList<StudentDTO> student_list;
	ObservableList<StudentGrade> studentgrade_list = FXCollections.observableArrayList();
	
	public ObservableList<StudentDTO> getStudent_list() {
		return student_list;
	}
	public void setStudent_list(ObservableList<StudentDTO> student_list) {
		this.student_list = student_list;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btnPrint.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				IntegerProperty ip = new SimpleIntegerProperty();
				ip.setValue(0);
				
				for(int i = 0; i < student_list.size(); i++) {
					StudentDTO sd = student_list.get(i);
					StudentGrade sg = new StudentGrade();
					
					sg.setName(sd.getName());
					sg.setAverage(sd);
					
					StringProperty orderProperty = new SimpleStringProperty();
					if(sg.getAverage().getValue() <= 100 && sg.getAverage().getValue() >= 90) {
						orderProperty.setValue("A+");
						sg.setGrade(orderProperty);
					} else if(sg.getAverage().getValue() < 90 && sg.getAverage().getValue() >= 80) {
						orderProperty.setValue("A");
						sg.setGrade(orderProperty);
					} else if(sg.getAverage().getValue() < 80 && sg.getAverage().getValue() >= 70) {
						orderProperty.setValue("B+");
						sg.setGrade(orderProperty);
					} else if(sg.getAverage().getValue() < 70 && sg.getAverage().getValue() >= 60) {
						orderProperty.setValue("B");
						sg.setGrade(orderProperty);
					} else if(sg.getAverage().getValue() < 60 && sg.getAverage().getValue() >= 50) {
						orderProperty.setValue("C+");
						sg.setGrade(orderProperty);
					} else if(sg.getAverage().getValue() < 50 && sg.getAverage().getValue() >= 40) {
						orderProperty.setValue("C");
						sg.setGrade(orderProperty);
					} else {
						orderProperty.setValue("F");
						sg.setGrade(orderProperty);
					}
					
					sg.setOrder(ip);
					studentgrade_list.add(sg);
				}
				
				Collections.sort(studentgrade_list);
				
				for(int i = 0; i < studentgrade_list.size(); i++) {
					IntegerProperty temp = new SimpleIntegerProperty();
					temp.setValue(i+1);
					studentgrade_list.get(i).setOrder(temp);
				}
				
				name.setCellValueFactory(cellData -> cellData.getValue().getName());
				average.setCellValueFactory(cellData -> cellData.getValue().getAverage().asObject());
				order.setCellValueFactory(cellData -> cellData.getValue().getOrder().asObject());
				grade.setCellValueFactory(cellData -> cellData.getValue().getGrade());
				gradeTable.setItems(studentgrade_list);
			}
		});
		
		
		
		btnOK.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				exit();
			}

			public void exit() {
				Stage stage = (Stage) btnOK.getScene().getWindow();
				stage.close();
				
			}
		});
	}

}
