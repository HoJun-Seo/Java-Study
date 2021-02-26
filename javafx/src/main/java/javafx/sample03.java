package javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class sample03 extends Application {

	@Override
	public void start(Stage primaryStage) {
		System.out.println("sample03 start()....");
		
		// 컨테이너 생성 => 요소 생성
		
		Button btn1 = new Button();
		btn1.setText("확인");
		btn1.setOnAction(e -> {
			System.out.println("안녕하세요");
		});
		
		HBox root = new HBox();
		root.setPrefWidth(200);
		root.setPrefHeight(200);
		
		root.getChildren().add(btn1);
		// Scene 요소에 컨테이너 생성
		Scene sc = new Scene(root);
		
		primaryStage.setScene(sc);
		primaryStage.setTitle("처음 만든 윈도우창");
//		primaryStage.setWidth(400);
//		primaryStage.setHeight(300);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args); // start() 
	}
}
