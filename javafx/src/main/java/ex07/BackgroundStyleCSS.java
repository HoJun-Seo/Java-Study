package ex07;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BackgroundStyleCSS extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/backgroundstyle.fxml"));
		Scene scene = new Scene(root);

		String urlStr = getClass().getResource("css/style04.css").toExternalForm();
		scene.getStylesheets().add(urlStr);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
