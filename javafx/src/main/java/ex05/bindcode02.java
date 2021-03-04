package ex05;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class bindcode02 extends Application {
	
	// ProperyVo 클래스 작성 
	public class ProperyVo {
		private IntegerProperty value = new SimpleIntegerProperty();
		public int getValue() {
			return value.get();
		}
		public void setValue(int value) {
			this.value.set(value);
		}
		public IntegerProperty valueProperty() {
			return value;
		}
		
	}

	@Override
	public void start(Stage primaryStage) {
		// 최상위 컨테이너
		FlowPane flowPane = new FlowPane(Orientation.VERTICAL);
		flowPane.setAlignment(Pos.CENTER);
		flowPane.setPadding(new Insets(10));
		flowPane.setVgap(10);
		
		Label lbl = new Label("텍스트 변경");
		lbl.setPrefWidth(200);
		
		flowPane.getChildren().add(lbl);
		
		TextField txt = new TextField();
		txt.prefWidth(200);
		flowPane.getChildren().add(txt);
		
		// Property 객체생성 및 TextField text 속성과 바인딩
		ProperyVo propertyVo = new ProperyVo();
		txt.textProperty().bind(propertyVo.valueProperty().asString());
		
		Button btn = new Button("1씩 증가");
		btn.setPrefWidth(100);
		flowPane.getChildren().add(btn);
		
		// 이벤트 처리
		btn.setOnAction(e -> {
			propertyVo.setValue(propertyVo.getValue() + 1);
		});
//		Scene scene = new Scene(flowPane, 250, 150);
//		primaryStage.setScene(scene);
		
		primaryStage.setScene(new Scene(flowPane, 250, 150));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
