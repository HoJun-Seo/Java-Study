package ex04;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class listenerController implements Initializable{
	@FXML private Label lt1;
	@FXML private Slider slider;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("슬라이더 값이 변경되고 있는 중 : " + newValue);
				lt1.setFont(new Font(newValue.doubleValue()));
			}
		});
	}
}
