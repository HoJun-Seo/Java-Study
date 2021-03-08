package ex06.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class chartController implements Initializable{
	@FXML private PieChart pieChart;
	@FXML private BarChart<String, Integer> barChart;
	@FXML private AreaChart<String, Integer> areaChart;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// 파이 차트
		pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("AWT", 10),
				new PieChart.Data("Swing", 30),
				new PieChart.Data("SWT", 25),
				new PieChart.Data("JavaFX", 35)
				));
		
		// 축이 있는 차트 설정
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		series1.setName("남자");
		series1.setData(FXCollections.observableArrayList(
				new XYChart.Data("2018", 70),
				new XYChart.Data("2019", 40),
				new XYChart.Data("2020", 50),
				new XYChart.Data("2017", 30)
				));
		
		XYChart.Series<String, Integer> series2 = new XYChart.Series<String, Integer>();
		series2.setName("여자");
		series2.setData(FXCollections.observableArrayList(
				new XYChart.Data("2018", 13),
				new XYChart.Data("2019", 6),
				new XYChart.Data("2020", 22),
				new XYChart.Data("2017", 19)
				));
		
		barChart.getData().add(series1);
		barChart.getData().add(series2);
		
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("평균 온도");
		series3.setData(FXCollections.observableArrayList(
				new XYChart.Data("2018", 13),
				new XYChart.Data("2019", 6),
				new XYChart.Data("2020", 22),
				new XYChart.Data("2017", 19)
				));
		
		areaChart.getData().add(series3);
	}

}
