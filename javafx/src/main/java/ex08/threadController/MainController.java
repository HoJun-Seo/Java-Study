package ex08.threadController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ex08.AppMain;
import ex08.util.Animation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class MainController implements Initializable {
	@FXML private Button btnList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtnList(event);
			}
		});
	}
	
	public void handleBtnList(ActionEvent event) {
		try {
			Parent parent = FXMLLoader.load(ListController.class.getResource("/ex08/list/list_scene.fxml"));
			AppMain.stackPane.getChildren().add(parent);
			Animation.fade(parent, 0, 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
