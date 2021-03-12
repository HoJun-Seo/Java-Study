package javafx_practice.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx_practice.dto.StudentDTO;

public class StudentBarController implements Initializable{
	@FXML BarChart<String, Integer> barChart;
	@FXML Button btnPrint;
	
	ObservableList<StudentDTO> student_list;
	
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
				XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
				XYChart.Series<String, Integer> series2 = new XYChart.Series<String, Integer>();
				XYChart.Series<String, Integer> series3 = new XYChart.Series<String, Integer>();
				XYChart.Series<String, Integer> series4 = new XYChart.Series<String, Integer>();
				XYChart.Series<String, Integer> series5 = new XYChart.Series<String, Integer>();
				
				series1.setName("국어");
				series2.setName("영어");
				series3.setName("수학");
				series4.setName("사회");
				series5.setName("과학");
					
				ObservableList<XYChart.Data<String, Integer>> korean_list = FXCollections.observableArrayList();
				ObservableList<XYChart.Data<String, Integer>> english_list = FXCollections.observableArrayList();
				ObservableList<XYChart.Data<String, Integer>> math_list = FXCollections.observableArrayList();
				ObservableList<XYChart.Data<String, Integer>> social_list = FXCollections.observableArrayList();
				ObservableList<XYChart.Data<String, Integer>> science_list = FXCollections.observableArrayList();
						
				for(int i = 0; i < student_list.size(); i++) {
					StudentDTO student = student_list.get(i);
					String name = student.getName().getValue();
					Integer score_korean = Integer.parseInt(student.getKorean().getValue());
					Integer score_english = Integer.parseInt(student.getEnglish().getValue());
					Integer score_math = Integer.parseInt(student.getMath().getValue());
					Integer score_social = Integer.parseInt(student.getSocial().getValue());
					Integer score_science = Integer.parseInt(student.getScience().getValue());
					
					korean_list.add(new XYChart.Data<String, Integer>(name, score_korean));
					english_list.add(new XYChart.Data<String, Integer>(name, score_english));
					math_list.add(new XYChart.Data<String, Integer>(name, score_math));
					social_list.add(new XYChart.Data<String, Integer>(name, score_social));
					science_list.add(new XYChart.Data<String, Integer>(name, score_science));
				}
				
				series1.setData(korean_list);
				series2.setData(english_list);
				series3.setData(math_list);
				series4.setData(social_list);
				series5.setData(science_list);
				
				barChart.getXAxis().setAnimated(false); // 카테고리 겹침 문제 해결
				barChart.getData().addAll(series1, series2, series3, series4, series5);
			}
		});
	}
			
}
