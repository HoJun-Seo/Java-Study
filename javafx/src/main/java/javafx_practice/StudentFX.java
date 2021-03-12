package javafx_practice;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StudentFX extends Application {
	
	public static AnchorPane anchorPane;

	@Override
	public void start(Stage primaryStage) throws IOException {
		anchorPane = (AnchorPane) FXMLLoader.load(StudentFX.class.getResource("view/studentView.fxml"));
		Scene scene = new Scene(StudentFX.anchorPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
