package ex05;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class BorderPaneCode extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		// root 컨테이너 생성
//		BorderPane root = new BorderPane();
//		FlowPane root = new FlowPane(Orientation.VERTICAL); // 수직방향 정렬
		GridPane root = new GridPane();
		
		// 컨트롤 생성(UI)
		Button btn1 = new Button("버튼1");
		Button btn2 = new Button("버튼2");
		Button btn3 = new Button("버튼3");
		Button btn4 = new Button("버튼4");
		Button btn5 = new Button("버튼5");
		
		btn1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		btn5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		// GridPane 행과 열의 너비 및 높이 비율 지정
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(30); // 화면의 너비 30%
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(70); // 화면의 너비 70%
		
		root.getColumnConstraints().addAll(col1, col2);
		
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(20); // 화면의 높이 20%
		RowConstraints row2 = new RowConstraints();
		row1.setPercentHeight(50); // 화면의 높이 50%
		RowConstraints row3 = new RowConstraints();
		row1.setPercentHeight(30); // 화면의 높이 30%
		
		root.getRowConstraints().addAll(row1,row2,row3);
		
//		root.setTop(btn1);
//		root.setLeft(btn2);
//		root.setCenter(btn3);
//		root.setRight(btn4);
//		root.setBottom(btn5);
		
		// FlowPane : 컨테이너에 화면 배치 - 컨트롤 추가
//		root.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
		root.add(btn1, 0, 0); // 열, 행
		root.add(btn2, 1, 0);
		root.add(btn3, 0, 1);
		root.add(btn4, 1, 1);
		root.add(btn5, 0, 2, 2, 1);
		
		Scene scene = new Scene(root, 300, 150);
		primaryStage.setScene(scene);
		primaryStage.setTitle("BorderPane Layout");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
