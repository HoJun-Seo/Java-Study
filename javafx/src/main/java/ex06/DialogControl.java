package ex06;

import java.io.IOException;

import ex06.controller.DialogController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DialogControl extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
//		Parent root = FXMLLoader.load(getClass().getResource("view/dialogView.fxml"));
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view/dialogView.fxml"));
		Parent root = loader.load();
		
		DialogController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
