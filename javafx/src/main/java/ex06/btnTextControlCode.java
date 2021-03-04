package ex06;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class btnTextControlCode extends Application {

	@Override
	public void start(Stage primaryStage) {
		AnchorPane root = new AnchorPane();
		
		TextField txt = new TextField();
		txt.setLayoutX(10);
		txt.setLayoutY(10);
		txt.setPrefSize(200, 30);
		
		Button btn = new Button("버튼");
		btn.setLayoutX(10);
		btn.setLayoutY(50);
		btn.setPrefSize(100, 30);
		
		root.getChildren().addAll(txt, btn);
		
		primaryStage.setScene(new Scene(root, 300, 150));
		primaryStage.show();
		
		// 클릭 이벤트 처리
		btn.setOnAction(e -> {
			// 텍스트 문자열 전체 선택 처리
			txt.requestFocus();
			txt.selectAll();
			
			String text = txt.getSelectedText();
			System.out.println("선택한 텍스트 : " + text);
			
			txt.home();
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
