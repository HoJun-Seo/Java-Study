package javafx_practice.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx_practice.dto.StudentDTO;

public class StudentController implements Initializable{
	@FXML private TableView<StudentDTO> studentTable;
	@FXML private TableColumn<StudentDTO, String> name;
	@FXML private TableColumn<StudentDTO, String> korean;
	@FXML private TableColumn<StudentDTO, String> english;
	@FXML private TableColumn<StudentDTO, String> math;
	@FXML private TableColumn<StudentDTO, String> social;
	@FXML private TableColumn<StudentDTO, String> science;
	@FXML private Button btnAdd;
	@FXML private Button btnBar;
	
	ObservableList<StudentDTO> student_list = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		korean.setCellValueFactory(cellData -> cellData.getValue().koreanProPerty());
		english.setCellValueFactory(cellData -> cellData.getValue().englishProperty());
		math.setCellValueFactory(cellData -> cellData.getValue().mathProperty());
		social.setCellValueFactory(cellData -> cellData.getValue().mathProperty());
		science.setCellValueFactory(cellData -> cellData.getValue().mathProperty());
		studentTable.setItems(student_list);
		
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				handlebtnAdd(event);
			}
		});
		
		btnBar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				handlebtnBar(event);
			}
		});
	}
	
	public void handlebtnAdd(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx_practice/view/studentAddView.fxml"));
			Parent root = loader.load();
			StudentAddController controller = loader.getController();
			controller.setStudent_list(student_list);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void handlebtnBar(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafx_practice/view/studentBarView.fxml"));
			Parent root = loader.load();
			StudentBarController controller = loader.getController();
			controller.setStudent_list(student_list);
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
