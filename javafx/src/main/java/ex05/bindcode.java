package ex05;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class bindcode extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		// 최상위 컨테이너
		FlowPane flowPane = new FlowPane();
		flowPane.setAlignment(Pos.CENTER); // 추가되는 컨트롤을 화면 중앙으로 배치
		flowPane.setPadding(new Insets(10)); // 컨테이너의 상하좌우 여백 10px
		flowPane.setHgap(20); // 추가되는 컨트롤 간격을 20px
		
		TextField txt1 = new TextField();
		txt1.prefWidth(200);
		
		Label lbl = new Label("TextField 와 동기화 됨");
		lbl.setPrefWidth(200);
		
		// 컨테이너에 컨트롤 추가
		flowPane.getChildren().addAll(txt1, lbl);
		
		// 두 객체 동기화
		lbl.textProperty().bind(txt1.textProperty());
		
		Scene scene = new Scene(flowPane, 450, 100);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

/*
 * Property 속성
 * TextField, Button, Label :
 * 	text => textProperty(), width => widthProperty(), prefWidth => widthProperty()
 *
 * Property 클래스
 * 	StringProperty(), DoubleProperty(), IntegerProperty(), ...
 * 	SimpleStringProperty(), SimpleDoubleStringProperty(), ...
 */
