package javaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFxTest02 extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		// UI 생성		
		Label label = new Label(); // 개별 UI
		label.setText("Hello, JavaFX");
		label.setFont(new Font(50));
				
		Button btn = new Button(); // 개별 UI
		btn.setText("확인 버튼");
		
		VBox root = new VBox(); // 컨테이너
		root.setPrefHeight(150);
		root.setPrefWidth(350);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
				
		root.getChildren().addAll(label, btn);
		Scene sc = new Scene(root); // 장면
		
		primaryStage.setScene(sc);
		primaryStage.show(); // 윈도우 창
	}

	public static void main(String[] args) {
		launch(args);
	}
}
