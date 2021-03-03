package ex04;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EventTest extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		URL resource = getClass().getResource("view/eventView.fxml");
		AnchorPane root = FXMLLoader.load(resource);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
