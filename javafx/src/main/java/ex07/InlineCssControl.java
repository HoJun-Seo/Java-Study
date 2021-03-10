package ex07;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InlineCssControl extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/InlineCSSView.fxml"));
		Scene scene = new Scene(root);
		// 외부 스타일 시트 부착
		// 방법 1
//		scene.getStylesheets().add(getClass().getResource("css/style01.css").toString());
		
		// 방법 2
		String urlStr = getClass().getResource("css/style01.css").toExternalForm();
		scene.getStylesheets().add(urlStr);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
