package ex04;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class listenerBindings01Controller implements Initializable {
	@FXML private Circle circle;
	@FXML private AnchorPane root;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 원 객체 중앙 정렬
		// 원 폭 / 2 연산을 통해 객체를 중앙에 항상 고정시킨다.
//		circle.centerXProperty().bind(Bindings.divide(root.widthProperty(), 2.0));
//		circle.centerYProperty().bind(Bindings.divide(root.heightProperty(), 2.0));
		
		//AnchorPane 컨테이너 너비 변동 시 수행
		root.widthProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("W : " + newValue);
				circle.setCenterX(newValue.doubleValue()/2);
			}
		});
		
		//AnchorPane 컨테이너 높이 변동시 수행
		root.heightProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("H : " + newValue);
				circle.setCenterY(newValue.doubleValue()/2);
			}
		}) ;
	}

}
