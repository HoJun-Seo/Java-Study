package ex03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class button01 extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane root = new Pane(); // 컨트롤 객체를 그룹핑
		
		// 
		Button btn1 = new Button("버튼 1");
		btn1.setPrefWidth(100);
		btn1.setPrefHeight(20);
		// btn.setPrefSize(100,20);
		btn1.setLayoutX(10);
		btn1.setLayoutY(10);
		
		TextField txt1 = new TextField();
		btn1.setPrefSize(200, 30);
		txt1.setLayoutX(10);
		txt1.setLayoutY(50);
		
		root.getChildren().add(btn1);
		root.getChildren().add(txt1);
//		root.getChildren().addAll(btn1, txt1);
		
		btn1.setOnAction(e -> {
			System.out.println("버튼1을 클릭 했습니다.");
			txt1.setText("안녕하세요 텍스트 필드 입니다.");
		});
		
		Scene scene = new Scene(root, 300, 200);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("컨트롤 생성");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
