package ex03;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class button02 extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException  {
		Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

/*
 * 레이아웃 :
 * AnchorPane : 좌표로 배치 하는 레이아웃
 * BorderPane : 위,아래,왼쪽,오른쪽,가운데,아래쪽
 * FlowPane : 행 배치
 * GridPane : 행열 방식 배치
 * StackPane : 겹쳐서 배치
 * TilePane : 그리드로 배치하되 고정된 셀의 크기로 배치
 * HBox : 수평으로 배치
 * VBox : 수직으로 배치
 */
